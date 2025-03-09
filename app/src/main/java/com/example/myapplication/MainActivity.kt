package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.IntegerRes
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.myapplication.data.Data
import com.example.myapplication.screens.MainCard
import com.example.myapplication.screens.TabLayout
import com.example.myapplication.screens.background
import com.example.myapplication.ui.theme.MyApplicationTheme
import org.json.JSONObject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            MyApplicationTheme {
                val daysList = remember {
                    mutableStateOf(listOf<Data>())
                }
                getData(52.2978F, 104.2964F, this, daysList)
                background()
                Column {
                    MainCard()
                    TabLayout(daysList)
                }
            }

        }
    }
}
//52.2978
//104.2964 Irkutsk
private fun getData(latitude: Float, longitude: Float,context: Context, daysList: MutableState<List<Data>>) {
    val URL = "https://api.open-meteo.com/v1/forecast?latitude=$latitude&longitude=$longitude&current=temperature_2m,weather_code&hourly=temperature_2m,weather_code&daily=weather_code,temperature_2m_max,temperature_2m_min&timezone=auto"
    val queue = Volley.newRequestQueue(context)
    val sRequest = StringRequest(
        Request.Method.GET,
        URL,
        { response ->
            val list = getWeatherByDays(response)
            daysList.value = list
        },
        { Log.d("MyLog", "$it") }
    )
    queue.add(sRequest)
}
private fun getWeatherByDays(response: String): List<Data>{
    if (response.isEmpty()){
        return listOf()
    }
    val list = ArrayList<Data>()
    val mainObject = JSONObject(response)
    val days = mainObject.getJSONObject("daily").getJSONArray("time")
    val code = mainObject.getJSONObject("daily").getJSONArray("weather_code")
    val maxTemp = mainObject.getJSONObject("daily").getJSONArray("temperature_2m_max")
    val minTemp = mainObject.getJSONObject("daily").getJSONArray("temperature_2m_min")
    for (i in 0 until days.length()){
        list.add(
            Data(days[i].toString(),
                "",
                minTemp[i].toString(),
                maxTemp[i].toString(),
                getCondition(code[i].toString()),
                getIcon(code[i].toString())
                )
        )
    }
    return list
}
private fun getCondition(code: String): String {
    val code1: Int = Integer.parseInt(code)
    return when (code1) {
        0 -> "Ясное небо"
        1, 2, 3 -> "В основном ясно"
        45, 48 -> "Туман"
        51, 53, 55, 56, 57 -> "Морось"
        61, 63, 65, 66, 67 -> "Дождь"
        71, 73, 75, 77 -> "Снегопад"
        80, 81, 82 -> "Ливневый дождь"
        85, 86 -> "Ливневый снег"
        else -> "Не удалось определить"
    }
}
private fun getIcon(code: String): String{
    val code1: Int = Integer.parseInt(code)
    return when (code1) {
        0 -> "R.drawable.a0"
        1, 2, 3 -> "R.drawable.b1"
        45, 48 -> "R.drawable.c2"
        51, 53, 55, 56, 57, 61, 63, 65, 66, 67 -> "R.drawable.d3"
        71, 73, 75, 77 -> "R.drawable.e4"
        80, 81, 82 -> "R.drawable.f5"
        85, 86 -> "R.drawable.g6"
        else -> "Error"
    }
}




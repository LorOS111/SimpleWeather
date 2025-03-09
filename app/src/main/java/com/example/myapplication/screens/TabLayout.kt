package com.example.myapplication.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.data.Data
import com.example.myapplication.ui.theme.mainCol
import com.example.myapplication.ui.theme.notmainCol
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
public fun TabLayout(daysList: MutableState<List<Data>>){
    val TABSLIST = listOf("HOURS", "DAYS") //Лист с названиями вкладок
    val pagerState = rememberPagerState(pageCount = {TABSLIST.size}) //состояние пагера , параметр указывает сколько будет их
    val tabIndex = pagerState.currentPage //Индекс текущей страницы
    val coroutineScope = rememberCoroutineScope() //анимашка

    Column(
        modifier = Modifier
            .padding(start = 5.dp, end = 5.dp)
            .clip(RoundedCornerShape(5.dp))
    ) {
        TabRow(
            indicator = { tabPositions ->
                TabRowDefaults.SecondaryIndicator(
                    Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage]),
                    color = notmainCol
                )
            },
            selectedTabIndex = tabIndex,
            containerColor = mainCol,
            divider = { HorizontalDivider(color = Color.Transparent) }
        ) {
            TABSLIST.forEachIndexed{index, text ->
                Tab(
                    selected = tabIndex == index,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = {
                        Text(text=text, color = Color.White )
                    })
            }
        }
    }
    HorizontalPager(
        state = pagerState,
        modifier = Modifier
    ) { index ->
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            itemsIndexed(
                daysList.value
            ){_, item ->
                itemInListItem(item)
            }
        }
    }

}
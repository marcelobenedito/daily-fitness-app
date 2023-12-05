package com.github.marcelobenedito.dailyfitness.ui

import android.content.res.Configuration
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.marcelobenedito.dailyfitness.R
import com.github.marcelobenedito.dailyfitness.data.repository.DailyFitnessTipsRepository
import com.github.marcelobenedito.dailyfitness.model.FitnessTip
import com.github.marcelobenedito.dailyfitness.ui.theme.DailyFitnessTheme

@Composable
fun FitnessTipDayBadge(day: Int, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .padding(top = 32.dp)
            .shadow(2.dp, shape = RoundedCornerShape(25.dp))
            .background(MaterialTheme.colorScheme.secondary)
            .padding(vertical = 4.dp, horizontal = 16.dp)
    ) {
        Text(
            text = "Day $day",
            color = Color.White,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun FitnessTipItem(fitnessTip: FitnessTip, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = modifier) {
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded }
            ) {
                Image(
                    painter = painterResource(id = fitnessTip.image),
                    contentDescription = stringResource(id = fitnessTip.title),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                )
                Row(modifier = Modifier.wrapContentHeight()) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = stringResource(id = fitnessTip.title),
                            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                        )
                        if (expanded) {
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(
                                text = stringResource(id = fitnessTip.description),
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            }
        }
        FitnessTipDayBadge(day = fitnessTip.day)
    }
}

@Composable
fun FitnessTipList(
    fitnessTipList: List<FitnessTip>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues
) {
    LazyColumn(
        contentPadding = contentPadding,
        modifier = modifier
        .padding(start = 16.dp, end = 16.dp, top = 8.dp)
    ) {
        items(fitnessTipList) { fitnessTip ->
            FitnessTipItem(fitnessTip = fitnessTip)
        }
    }
}

@Preview("Light mode")
@Preview("Dark mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun FitnessTipItemPreview() {
    DailyFitnessTheme {
        FitnessTipItem(
            fitnessTip = FitnessTip(
                day = 1,
                title = R.string.title_1,
                description = R.string.description_1,
                image = R.drawable.image_1
            )
        )
    }
}

@Preview
@Composable
fun FitnessTipListPreview() {
    DailyFitnessTheme {
        FitnessTipList(
            fitnessTipList = DailyFitnessTipsRepository.fitnessTips,
            contentPadding = PaddingValues(0.dp)
        )
    }
}
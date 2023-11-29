package com.alxgrbdev.a30days

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.alxgrbdev.a30days.data.Tip
import com.alxgrbdev.a30days.model.TipsRepository.tips

@Composable
fun TipsList(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small)),
        modifier = modifier.padding(dimensionResource(id = R.dimen.padding_medium))
    ) {
        items(tips) {
            TipCard(
                tip = it
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TipCard(
    tip: Tip,
    modifier: Modifier = Modifier
) {
    var extended by remember { mutableStateOf(false) }
    val color by animateColorAsState(
        targetValue = if (extended) MaterialTheme.colorScheme.tertiaryContainer else MaterialTheme.colorScheme.primaryContainer,
        label = ""
    )

    Card(
        onClick = { extended = !extended },
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .background(color = color)
        ) {
            Column(
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_medium)),
            ) {
                Text(
                    text = "Day " + stringResource(id = tip.day),
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = stringResource(id = tip.title),
                    style = MaterialTheme.typography.displaySmall
                )
                Image(
                    painter = painterResource(id = R.drawable.ph_500_400),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(dimensionResource(id = R.dimen.image_height))
                        .padding(vertical = dimensionResource(id = R.dimen.padding_small))
                )
                if (extended) {
                    Text(
                        text = stringResource(id = tip.description),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun CardPreview() {
    TipCard(tip = Tip(R.string.day_1, R.string.tip_title_1, R.drawable.ph_500_400, R.string.tip_description_1))
}

@Preview
@Composable
private fun ListPreview() {
    TipsList()
}

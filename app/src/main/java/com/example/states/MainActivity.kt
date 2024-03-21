package com.example.states

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.FlowRowScopeInstance.weight
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.states.data.DataSource
import com.example.states.ui.theme.StatesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StatesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CarsList()
                }
            }
        }
    }
}

@Composable
fun CarsList(
    modifier: Modifier = Modifier,
    places: List<String> = listOf(
        "Germany",
        "Italy",
        "Britain",
        "North America",
        "Japan"
    ),
    images: List<Int> = DataSource().loadImages().map { it.imageResource },
    texts: List<String> = listOf( // Add a list of texts
        "Famous for BMW and Mercedes",
        "Home of Ferrari and Lamborghini",
        "Known for luxury brands like Rolls-Royce",
        "Muscle cars and trucks",
        "Advanced technology in cars"
    )
) {
    Column(modifier = modifier.padding(vertical = 5.dp)) {
            for (index in places.indices) {
                val place = places[index]
                val imageId = images[index] // Access image ID based on index
                val currentText = texts[index] // Access text based on index

                Places(y = place, imageId = imageId, text = currentText)
            }
        }
    }

/*@Composable
fun CarsList( modifier: Modifier = Modifier,
              places :List<String> = listOf("Germany","Italy","Britain","North America","Japan",)

) {

        Column(modifier = modifier.padding(vertical = 5.dp)) {
            for (y in places) {
                Places(
                    y = y


                )
            }

            }
        }

 */


@Composable
fun Places(y: String, text:String, imageId: Int, modifier: Modifier = Modifier) {
    var collapsed by rememberSaveable { mutableStateOf(false) }
    val extraPadding = if (collapsed) 60.dp else 0.dp
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = modifier.padding(vertical = 5.dp, horizontal = 10.dp)
    ) {
        Row(modifier = Modifier.padding(26.dp)) {
            /*Image(
                painter = painterResource(id = imageId), // Use image ID from parameter
                contentDescription = null,
                modifier = Modifier
                    .weight(1f)
                    .height(100.dp) // Adjust image height as needed
            )

             */
            Column(modifier = Modifier
                .weight(1f)
                .padding(bottom = extraPadding)) {
                Text(text = "Country of Origin")
                Text(text = y)

                if (collapsed){
                    Text(text = text)
                Image(
                    painter = painterResource(id = imageId),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        , contentScale = ContentScale.Crop
                )

                }
            }
            IconButton(onClick = { collapsed = !collapsed }) {
                Icon(
                    imageVector = if (collapsed) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                    contentDescription = if (collapsed) {
                        stringResource(id = R.string.show_less)
                    } else {
                        stringResource(id = R.string.show_more)
                    }
                )
            }
        }
    }
}

/*@Composable
fun Places(y: String, modifier: Modifier =Modifier) {
    var collapsed by rememberSaveable{ mutableStateOf(false) }
    val extraPadding = if (collapsed) 60.dp else 0.dp
    Surface (
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(vertical = 5.dp, horizontal = 10.dp)
    ){
        Row(modifier = Modifier.padding(26.dp)) {
            Column(modifier = Modifier
                .weight(1f)
                .padding(bottom = extraPadding)) {
                Text(text = "Country of Origin")
                Text(text = y)
            }
            IconButton(onClick = {
                collapsed = !collapsed
            }) {
                Icon(
                    imageVector = if (collapsed) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                    contentDescription = if (collapsed) {
                        stringResource(id = R.string.show_less)
                    } else {
                        stringResource(id = R.string.show_more)
                    }
                )
            }
        }
    }
}

 */

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StatesTheme {
        CarsList()
    }
}
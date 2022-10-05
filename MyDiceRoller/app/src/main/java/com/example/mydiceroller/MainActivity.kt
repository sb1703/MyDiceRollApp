package com.example.mydiceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mydiceroller.ui.theme.MyDiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyDiceRollerTheme {
                MyDiceRollerApp()
            }
        }
    }
}

@Preview
@Composable
fun MyDiceRollerApp(){
    MyDiceRollerAppBuildImageAndRun(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun MyDiceRollerAppBuildImageAndRun(modifier: Modifier = Modifier){

    var result1 by remember {
        mutableStateOf(1)
    }

    var result2 by remember {
        mutableStateOf(1)
    }

    val imageResource1 = when(result1){
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    val imageResource2 = when(result2){
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(imageResource1), contentDescription = result1.toString())

        Image(painter = painterResource(imageResource2), contentDescription = result2.toString())
        
        Spacer(modifier = Modifier.height(25.dp))

        Button(onClick = { result1 = (1..6).random() ; result2 = (1..6).random()}) {
            Text(text = stringResource(R.string.roll), fontSize = 24.sp)
        }
    }
}
package com.dapo.identityfetcher

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dapo.identityfetcher.ui.theme.IdentityFetcherTheme

class MainActivity : ComponentActivity() {

    private var text: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = Color.White) {
                MyApp()
            }
        }
    }

    @Composable
    fun MyApp() {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            MyTextField()
            Spacer(modifier = Modifier.size(20.dp))
            MyButton()
        }
    }

    @Composable
    fun MyTextField() {

        val textValue = remember { mutableStateOf("") }

        val primaryColor = colorResource(id = R.color.colorPrimary)
        OutlinedTextField(
            label = { Text(text = "Enter your name here") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = primaryColor,
                focusedLabelColor = primaryColor,
                cursorColor = primaryColor
            ),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
            value = textValue.value,
            onValueChange = {
                textValue.value = it
                text = textValue.value
            }
        )
    }

    @Composable
    fun MyButton() {
        val context = LocalContext.current
        Button(
            onClick = {
                Toast.makeText(
                    context,
                    "Hello $text",
                    Toast.LENGTH_SHORT
                ).show()
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.colorPrimary)),
            border = BorderStroke(
                1.dp,
                color = colorResource(id = R.color.colorPrimaryDark)
            )
        ) {
            Text(
                text = "Submit",
                color = Color.White
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        IdentityFetcherTheme {
            MyApp()
        }
    }
}


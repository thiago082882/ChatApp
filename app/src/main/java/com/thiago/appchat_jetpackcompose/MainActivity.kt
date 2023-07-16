package com.thiago.appchat_jetpackcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thiago.appchat_jetpackcompose.itemlista.UsuarioItem
import com.thiago.appchat_jetpackcompose.model.Usuario
import com.thiago.appchat_jetpackcompose.ui.theme.AppChatJetpackComposeTheme
import com.thiago.appchat_jetpackcompose.ui.theme.Green200
import com.thiago.appchat_jetpackcompose.ui.theme.Green500
import com.thiago.appchat_jetpackcompose.ui.theme.White

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppChatJetpackComposeTheme {
                Scaffold(
                    topBar = {

                        TopAppBar(
                            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Green500),
                            title = {
                                Text(
                                    text = "Chat",
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = White
                                )
                            }

                        )

                    },
                    containerColor = White


                ) {

                    ListUsuario()

                }
            }
        }
    }
}

@Composable
fun ListUsuario() {

    val context = LocalContext.current

    val listaUsuario: MutableList<Usuario> = mutableListOf(
        Usuario("Roni Cleyton", R.drawable.homem),
        Usuario("Ana Clara", R.drawable.mulher),
        Usuario("Rufus silva", R.drawable.homem),
        Usuario("Bianca Costa", R.drawable.mulher),
        Usuario("Clebson amaral", R.drawable.homem),
        Usuario("Roberta Tavares", R.drawable.mulher),
        Usuario("Rafael silvano", R.drawable.homem),
        Usuario("Marina silva", R.drawable.mulher),
        Usuario("Luiz Fernando", R.drawable.homem),
    )
    LazyColumn(modifier = Modifier.padding(top = 56.dp)) {
        itemsIndexed(listaUsuario) { position, _ ->
            UsuarioItem(
                listaUsuario = listaUsuario,
                position = position,
                context = context
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppChatJetpackComposeTheme {

    }
}
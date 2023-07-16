package com.thiago.appchat_jetpackcompose.itemlista

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.thiago.appchat_jetpackcompose.model.Usuario
import com.thiago.appchat_jetpackcompose.ui.theme.White

@Composable
fun UsuarioItem(
    listaUsuario: MutableList<Usuario>,
    position : Int,
    context: Context
) {
    val nome = listaUsuario[position].nome
    val fotoUsuario=listaUsuario[position].foto
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .background(White)

    ) {
        val (txtNome, foto, mensagem,linha) = createRefs()
        Image(
            painter = painterResource(id = fotoUsuario!!),
            contentDescription = "Foto do usuário",
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .constrainAs(foto) {
                    top.linkTo(parent.top, margin = 20.dp,)
                    start.linkTo(parent.start, margin = 20.dp)

                },
            contentScale = ContentScale.Crop

        )
        TextButton(
            onClick = {
                Toast.makeText(context, "Usuario $nome", Toast.LENGTH_SHORT).show()
            },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = White
            ),
            modifier = Modifier.constrainAs(txtNome) {
                start.linkTo(foto.end, margin = 20.dp)
                top.linkTo(parent.top, margin = 20.dp)
                end.linkTo(parent.end, margin = 20.dp)
            }
        ) {
            Text(text = nome!!, fontSize = 18.sp)

        }
        Text(
            text = "Messagem Padrão...",
            fontSize = 14.sp,
            modifier = Modifier.constrainAs(mensagem) {
                top.linkTo(txtNome.bottom)
                start.linkTo(foto.end, margin = 20.dp)
                end.linkTo(parent.end, margin = 20.dp)
            }
        )
        Row(
            modifier = Modifier
                .background(Color.Gray)
                .width(250.dp)
                .height(1.2.dp)
                .constrainAs(linha) {
                    start.linkTo(foto.end, margin = 30.dp)
                    end.linkTo(parent.end, margin = 20.dp)
                    top.linkTo(mensagem.bottom, margin = 12.dp)
                }
        ){

        }

    }
}


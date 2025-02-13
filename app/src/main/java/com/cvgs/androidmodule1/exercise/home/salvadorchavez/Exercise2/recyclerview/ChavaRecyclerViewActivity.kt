package com.cvgs.androidmodule1.exercise.home.salvadorchavez.Exercise2.recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cvgs.androidmodule1.R
import com.cvgs.androidmodule1.exercise.home.salvadorchavez.Exercise2.recyclerview.PostEntity

class ChavaRecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /*****************************************
                    Variables
         ****************************************/
        val rvPost = findViewById<RecyclerView>(R.id.rvPost) // Lista

        val posts = listOf(
            PostEntity("@elTacoSupremo", "Hace 1 día", "Cuando dices 'gracias' al cajero y él te dice 'gracias a ti'... y ahora son besties de por vida", ""),
            PostEntity("@mariahCareyMx", "Hace 3 horas", "Ser adulto es básicamente decir 'la próxima semana me pongo las pilas' cada semana y nunca hacerlo", ""),
            PostEntity("@chemsMaster69", "Hace 2 días", "Ayer soñé que hacía ejercicio y hoy amanecí cansado, creo que mi cuerpo ya procesa los sueños como realidad", ""),
            PostEntity("@anaBananaXD", "Hace 5 minutos", "Me compré un planner para organizar mi vida y ahora el planner es el que está desorganizado 💀", ""),
            PostEntity("@luisitoFiuFiu", "Hace 6 horas", "Gente que apaga la alarma en cuanto suena: ¿qué se siente ser el main character de la vida?", ""),
            PostEntity("@ferchuUwU", "Hace 8 minutos", "Mi capacidad de concentración es increíble: puedo distraerme con absolutamente todo en segundos", ""),
            PostEntity("@carlangasLOL", "Hace 10 horas", "No hay sensación más poderosa que decir 'ya lo revisé' y no haberlo revisado jamás", ""),
            PostEntity("@sofiaSabe", "Hace 2 días", "Crecí y aprendí que el verdadero terror es abrir un correo que empieza con 'Estimado usuario'", ""),
            PostEntity("@mikeElPro", "Hace 4 horas", "Mi talento especial es convertir un 'voy a dormirme temprano' en 'ya son las 3 AM y estoy viendo teorías de conspiración'", ""),
            PostEntity("@andreamix", "Hace 7 minutos", "La vida adulta es darte cuenta de que 'qué flojera' y 'qué caro' son la misma cosa", ""),
            PostEntity("@daniElCrack", "Hace 3 días", "El arte de cocinar es ver recetas de 20 minutos y tardar 2 horas porque te distrajiste viendo TikToks", ""),
            PostEntity("@gabsmoralezzz", "Hace 50 minutos", "Voy a limpiar mi cuarto *pone música, se sienta en la cama y se pierde en el celular por 3 horas*", ""),
            PostEntity("@rickRollMx", "Hace 9 horas", "La verdadera razón por la que trabajo es para poder pedir comida sin culpa", ""),
            PostEntity("@paolalalalalala", "Hace 12 horas", "Ser adulto es básicamente decir 'ya mero es quincena' cada tres días", ""),
            PostEntity("@javivibes", "Hace 30 minutos", "No es flojera, es 'manejo estratégico de la energía' 🤡", "")
        )



        val adapter = PostsAdapter(posts)
        rvPost.adapter = adapter
        rvPost.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
            false)
    }

}
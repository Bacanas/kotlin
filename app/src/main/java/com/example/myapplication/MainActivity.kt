package com.example.myapplication // definindo um "container" para organizar o projeto, enfrenta conflito entre classes

//importando a biblioteca essencial que herda funcionalidades essenciais para gerenciar as atividades
import androidx.appcompat.app.AppCompatActivity

//A classe Bundle é usada para passar dados entre atividades em um aplicativo Android
import android.os.Bundle

//importanto elementos 
import android.widget.Button //botão
import android.widget.TextView //texto
import android.widget.Toast //mensagem pop up

//não é obrigatório, porém o Kotlin trabalha melhor quando orientamos ele a objetos

//criando a classe principal do nosso códio e herdamos as funcionalidades de AppCompat
class MainActivity : AppCompatActivity() {

    //definindo as váriaveis a serem manipuladas e armazenadas (elas serão privadas)
    private var pontuacaoTimeA: Int = 0
    private var pontuacaoTimeB: Int = 0

    //essas váriaveis vão servir para mostrar na tela o saldo das pntuações
    private lateinit var pTimeA: TextView// assim como Ts o Kotlin é fortemente tipado
    private lateinit var pTimeB: TextView

    //vamos chamar o override pois queremos sobrescrever uma função do pai
    override fun onCreate(savedInstanceState: Bundle?) {

        //nós chamamos  o método pai para garantir que ele vai ser usado aqui
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //esse código retorna a referência visiual, para que nós possamos interagir com o Text View
        pTimeA = findViewById(R.id.placarTimeA)
        pTimeB = findViewById(R.id.placarTimeB)

        //criando os botões da pontuação val == const
        val bTresPontosTimeA: Button = findViewById(R.id.tresPontosA)
        val bDoisPontosTimeA: Button = findViewById(R.id.doisPontosA)
        val bTLivreTimeA: Button = findViewById(R.id.tiroLivreA)
        val bTresPontosTimeB: Button = findViewById(R.id.tresPontosB)
        val bDoisPontosTimeB: Button = findViewById(R.id.doisPontosB)
        val bTLivreTimeB: Button = findViewById(R.id.tiroLivreB)
        val bReiniciar: Button = findViewById(R.id.reiniciarPartida)


        bTresPontosTimeA.setOnClickListener { adicionarPontos(3, "A") }

        bDoisPontosTimeA.setOnClickListener { adicionarPontos(2, "A") }

        bTLivreTimeA.setOnClickListener { adicionarPontos(1, "A") }

        bTresPontosTimeB.setOnClickListener { adicionarPontos(3, "B") }

        bDoisPontosTimeB.setOnClickListener { adicionarPontos(2, "B") }

        bTLivreTimeB.setOnClickListener { adicionarPontos(1, "B") }

        bReiniciar.setOnClickListener { reiniciarPartida() }


    }

    fun adicionarPontos(pontos: Int, time: String) {
        if(time == "A"){
            pontuacaoTimeA += pontos

        }else {
            pontuacaoTimeB += pontos

        }
        atualizaPlacar(time)
    }

    fun atualizaPlacar(time: String){
        if(time == "A"){
            pTimeA.setText(pontuacaoTimeA.toString())
        }else {
            pTimeB.setText(pontuacaoTimeB.toString())
        }
    }

    fun reiniciarPartida() {
        pontuacaoTimeA = 0
        pTimeA.setText(pontuacaoTimeA.toString())
        pontuacaoTimeB = 0
        pTimeB.setText(pontuacaoTimeB.toString())
        Toast.makeText(this,"Placar reiniciado", Toast.LENGTH_SHORT).show()

    }
}

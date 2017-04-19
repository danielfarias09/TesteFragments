package danielfarias.com.testefragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.facebook.drawee.backends.pipeline.Fresco;

import danielfarias.com.testefragments.fragments.AnimalsFragment;
import danielfarias.com.testefragments.fragments.FoodFragment;

public class MainActivity extends AppCompatActivity {
    // Pega o FragmentManager
    FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //deve ser inicializado exatamente aqui, em todas as activities que vão usá-lo
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);

        //Devo testar se é null para evitar erros na hora de virar a tela e os fragments serem chamados novamente
        //savedInstanceState só é nulo quando a activity é criada, e assim, podemos chamar o transaction e adicionar o
        //fragment default que é o Animals
        if(savedInstanceState == null){
            AnimalsFragment animalsFragment = new AnimalsFragment();

            //Deve-se trabalhar com Fragment Transaction o mais local que você puder
            FragmentTransaction ft = fm.beginTransaction();

            //primeiro parâmentro é o identificador do view group que vai conter os fragments
            //segundo é o fragment que vai estar por Default
            ft.add(R.id.fragment_container,animalsFragment,"animalsFragment");
            ft.commit();
        }
    }

    public void switchFragmentAnimals(View view){
        AnimalsFragment animalsFragment = new AnimalsFragment();
        FragmentTransaction ft = fm.beginTransaction();
        //ultimo argumento é uma tag que eu defino caso queira alterar esse fragment depois, eu busco ele pela tag
        ft.replace(R.id.fragment_container,animalsFragment,"animalsFragment");
        //Adiciona os fragments na pilha, caso eu aperte o botão voltar, ele volta para o fragment anterior ao invés de sair
        //só sai quando todos os fragments forem desempilhados
        ft.addToBackStack("pilha");
        ft.commit(); //OBS: Trabalho com o transaction bem local, para este commit não refletir em outro commit e dar erro

    }
    public void switchFragmentFood(View view){
        FoodFragment foodFragment = new FoodFragment();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container,foodFragment,"foodFragment");
        ft.addToBackStack("pilha");
        ft.commit();
    }

    public void forwardImageAnimals(View view){
        AnimalsFragment animalsFragment = (AnimalsFragment)fm.findFragmentByTag("animalsFragment");
        animalsFragment.forwardImage();
    }

    public void backImageAnimals(View view){
        AnimalsFragment animalsFragment = (AnimalsFragment)fm.findFragmentByTag("animalsFragment");
        animalsFragment.backImage();
    }

    public void forwardImageFood(View view){
        FoodFragment foodFragment = (FoodFragment)fm.findFragmentByTag("foodFragment");
        foodFragment.forwardImage();
    }

    public void backImageFood(View view){
        FoodFragment foodFragment = (FoodFragment)fm.findFragmentByTag("foodFragment");
        foodFragment.backImage();
    }
}

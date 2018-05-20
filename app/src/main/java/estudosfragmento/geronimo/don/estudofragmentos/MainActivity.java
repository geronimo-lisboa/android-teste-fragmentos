package estudosfragmento.geronimo.don.estudofragmentos;



import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import junit.framework.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.UnaryOperator;

public class MainActivity extends AppCompatActivity implements TesteFragmento.OnFragmentInteractionListener{

    private List<Pessoa> pessoas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Criação dos dados de teste.
        pessoas.add(new Pessoa(0, "Charlie", 19));
        pessoas.add(new Pessoa(1, "Easy", 39));
        pessoas.add(new Pessoa(2, "Able", 21));

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Hora de criar os fragments pras pessoas:
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        for(Pessoa p:pessoas){
            TesteFragmento frag = TesteFragmento.newInstance(p);
            String tag = "Pessoa_"+p.getId();
            fragmentTransaction.add(R.id.fragContainer, frag, tag);
        }
        fragmentTransaction.commit();//Commit das alterações



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                //Como adicionar fragmentos dinamicamente à tela:
//                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();//getFragmentManager().beginTransaction();
//                TesteFragmento frag = new TesteFragmento();
//                ft.add(R.id.fragContainer, frag);
//                ft.commit();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void updatePessoa(Pessoa pessoa) {
        List<Pessoa> newList = new ArrayList<>();
        for(Pessoa p:pessoas){
            if(p.getId().equals(pessoa.getId())){
                newList.add(pessoa);
            }else{
                newList.add(p);
            }
        }
        pessoas = newList;
    }

    @Override
    public void deletePessoa(Pessoa p) {
        String tag = "Pessoa_"+p.getId();
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.hide(fragment);
        fragmentTransaction.commit();
    }
}

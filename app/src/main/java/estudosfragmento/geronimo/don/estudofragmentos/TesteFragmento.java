package estudosfragmento.geronimo.don.estudofragmentos;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TesteFragmento.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TesteFragmento#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TesteFragmento extends Fragment {


    private Pessoa pessoa = null;
    private EditText edtTexto = null;
    private EditText edtValor = null;
    private Button btnUpdate, btnExcluir = null;

    private OnFragmentInteractionListener mListener;

    public TesteFragmento() {
        // Required empty public constructor
    }

    public static TesteFragmento newInstance(Pessoa pessoa) {
        TesteFragmento fragment = new TesteFragmento();
        //O Bundle carrega os parâmetros pra inicializaçao do fragmento. Quando o onCreate for invocado
        //os parâmetros estarão disponiveis em getArguments().
        Bundle args = new Bundle();
        args.putSerializable("Pessoa", pessoa);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //Pega o dado.
            pessoa = (Pessoa)getArguments().getSerializable("Pessoa");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragView = inflater.inflate(R.layout.fragment_teste_fragmento, container, false);
        //Passa os dados pras views no fragmento.
        edtTexto = (EditText)fragView.findViewById(R.id.edtTexto);
        edtTexto.setText(pessoa.getTexto());
        edtValor = (EditText)fragView.findViewById(R.id.edtValor);
        edtValor.setText(pessoa.getValor().toString());
        btnUpdate = (Button)fragView.findViewById(R.id.btnUpdateData);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pessoa.setValor(Integer.parseInt(edtValor.getText().toString()));
                pessoa.setTexto(edtTexto.getText().toString());
                //chama aquele que implementa a interface(no caso a activity)
                mListener.updatePessoa(pessoa);
            }
        });
        btnExcluir = (Button)fragView.findViewById(R.id.btnExcluir);
        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.deletePessoa(pessoa);
            }
        });
        return fragView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void updatePessoa(Pessoa p);
        void deletePessoa(Pessoa p);
    }
}

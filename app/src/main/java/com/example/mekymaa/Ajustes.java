package com.example.mekymaa;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Ajustes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Ajustes extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    TextView mp,name,email,id;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextView entry;

    public Ajustes() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Ajustes.
     */
    // TODO: Rename and change types and number of parameters
    public static Ajustes newInstance(String param1, String param2) {
        Ajustes fragment = new Ajustes();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_ajustes, container, false);

        mp=v.findViewById(R.id.mp);
        name=v.findViewById(R.id.ppm);
        email=v.findViewById(R.id.email);
        id=v.findViewById(R.id.id);

        mp.setText(String.valueOf(getArguments().getInt("mp")));
        name.setText(getArguments().getString("name"));
        email.setText(getArguments().getString("email"));
        id.setText(getArguments().getString("id"));

        entry=v.findViewById(R.id.textView144);
        entry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inted = new Intent(getActivity().getBaseContext(),modificarDatos.class);
                startActivity(inted);
            }
        });

        return v;
    }
    public void cerrarSesion(View view){
        Intent intent= new Intent(getActivity(), Principal.class);
        startActivity(intent);
    }

}
package com.vu.fragmentexample;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class ToolbarFragment extends Fragment implements OnSeekBarChangeListener
{
    private static int seekvalue = 10;
    private static EditText editText;

    ToolbarListener activityCallBack;

    public interface ToolbarListener
    {
        public void onButtonClick(int position, String text);
    }

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try
        {
            activityCallBack = (ToolbarListener)activity;
        }
        catch(ClassCastException e)
        {
            throw new ClassCastException(activity.toString() + "must implement ToolbarListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.toolbar_fragment, container, false);
        editText=(EditText)view.findViewById(R.id.editText1);
        final SeekBar seekBar = (SeekBar)view.findViewById(R.id.seekBar1);

        seekBar.setOnSeekBarChangeListener(this);

        final Button button = (Button)view.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                buttonClicked(v);
            }
        });

        return view;
    }

    public void buttonClicked(View view)
    {
        activityCallBack.onButtonClick(seekvalue, editText.getText().toString());
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
    {
        seekvalue = progress;
    }

    @Override
    public void onStartTrackingTouch(SeekBar arg0)
    {

    }

    @Override
    public void onStopTrackingTouch(SeekBar arg0)
    {

    }

    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.toolbar_fragment, container, false);

        editText = (EditText) view.findViewById(R.id.editText1);

        final SeekBar seekBar = (SeekBar) view.findViewById(R.id.seekBar1);

        seekBar.setOnSeekBarChangeListener(this);

        final Button button = (Button) view.findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                buttonClicked(v);
            }
        });

        /*public void buttonClicked(View view)
        {

        }*/

        /*@Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
        {
            seekvalue = progress;
        }

        @Override
        public void onStartTrackingTouch(SeekBar arg0)
        {

        }

        @Override
                public void onStopTrackingTouch(SeekBar arg0)
        {

        }


        return view;
    }*/


}

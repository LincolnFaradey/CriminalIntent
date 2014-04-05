package ru.homework.mine.criminalintent.app;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

/**
 * Created by faradey on 4/4/14.
 */
public class CriminalIntentJSONSerializer {
    private Context mContext;
    private String mFileName;

    public CriminalIntentJSONSerializer(Context context, String fileName) {
        mContext = context;
        mFileName = fileName;
    }

    public void saveCrimes(ArrayList<Crime> crimes)
                throws JSONException, IOException{
        JSONArray array = new JSONArray();
        for (Crime c : crimes){
            array.put(c.toJSON());
        }

        Writer writer = null;
        try {
            OutputStream out = mContext.openFileOutput(mFileName, Context.MODE_PRIVATE);
            writer = new OutputStreamWriter(out);
            writer.write(array.toString());
        }finally {
            if (writer != null) writer.close();
        }
    }
}

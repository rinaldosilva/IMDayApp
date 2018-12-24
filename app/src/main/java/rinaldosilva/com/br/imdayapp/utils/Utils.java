package rinaldosilva.com.br.imdayapp.utils;

import android.content.Context;

import java.io.InputStream;

public class Utils {

    public static String loadData(Context context, String fileName) {
        String value = "";
        try {
            InputStream in = context.getAssets().open(fileName);
            int sizeFile = in.available();
            byte[] buffer = new byte[sizeFile];
            in.read(buffer);
            in.close();
            value = new String(buffer);
        } catch (Exception e) {
        }
        return value;
    }
}

package ca;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import java.security.KeyStore;
import java.util.Enumeration;

public class ConvertToPFX {
    public static final String PKCS12 = "PKCS12";
    public static  String KEYSTORE_PASSWORD = "123456";
    public void toPFX(String[] info){
        try {
            String pfx_keystore_file = "D:/"+info[0]+".pfx";
            String jkx_keystore_file = "D:/"+info[0]+".jks";
            KeyStore inputKeyStore = KeyStore.getInstance("JKS");
            FileInputStream fis = new FileInputStream(jkx_keystore_file);
            char[] nPassword = null;
            if ((KEYSTORE_PASSWORD == null)
                    || KEYSTORE_PASSWORD.trim().equals("")) {
                nPassword = null;
            } else {
                nPassword = KEYSTORE_PASSWORD.toCharArray();
            }
            inputKeyStore.load(fis, nPassword);
            fis.close();
            KeyStore outputKeyStore = KeyStore.getInstance("PKCS12");
            outputKeyStore.load(null, KEYSTORE_PASSWORD.toCharArray());
            Enumeration enums = inputKeyStore.aliases();
            while (enums.hasMoreElements()) {
                String keyAlias = (String) enums.nextElement();
                System.out.println("alias=[" + keyAlias + "]");
                if (inputKeyStore.isKeyEntry(keyAlias)) {
                    Key key = inputKeyStore.getKey(keyAlias, nPassword);
                    java.security.cert.Certificate[] certChain = inputKeyStore
                            .getCertificateChain(keyAlias);
                    outputKeyStore.setKeyEntry(keyAlias, key, KEYSTORE_PASSWORD
                            .toCharArray(), certChain);
                }
            }
            FileOutputStream out = new FileOutputStream(pfx_keystore_file);
            outputKeyStore.store(out, nPassword);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        String[] info = {"key\\server"};
        ConvertToPFX ctf = new ConvertToPFX();
        ctf.toPFX(info);
    }
}
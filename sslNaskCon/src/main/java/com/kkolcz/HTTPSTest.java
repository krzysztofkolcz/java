package com.kkolcz;

/* import com.sun.net.ssl.HttpsURLConnection; */
/* import com.sun.net.ssl.KeyManagerFactory; */

import java.io.*;
import java.security.cert.*;
import java.security.KeyStore;
import java.net.URL;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.security.KeyStore;
import java.util.Properties;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

public class HTTPSTest
{
    public HTTPSTest() {}
    
    public static void main(String[] args)
    {
        try
        {
            for (int i = 0; i < 4; i++)
            {
                String command = 
              "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>" + 
              "<epp xmlns=\"http://www.dns.pl/nask-epp-schema/epp-2.0\""+
              " xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\""+
              " xsi:schemaLocation=\"http://www.dns.pl/nask-epp-schema/epp-2.0 epp-2.0.xsd\">" +
              "<hello/>"+
              "</epp>";

                String charset = "UTF-8";

                command = java.net.URLEncoder.encode(command, charset);

                // Dodaj komentarz do linii poniżej aby wysłać komendę
                // EPP <hello> bez parametru input.xml
                /* command = "input.xml=" + command; */
                System.out.println("KOMENDA = \n" + command);

                /* java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider()); */
                /* System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol"); */
                /* System.setProperty("javax.net.ssl.trustStore","c:\\exp_reg\\cacerts"); */
                /* System.setProperty("javax.net.ssl.keyStore","c:\\exp_reg\\jb.keystore"); */
                /* System.setProperty("javax.net.ssl.keyPassword","1q2w3e"); */

                
                /* URL url = new URL("https://grolsch.nask.waw.pl/registry/reg"); */
                URL url = new URL("https://qregistry.nask.waw.pl/registry/epp");
                
                HttpsURLConnection huc = (HttpsURLConnection) url.openConnection();

                huc.setRequestMethod("POST");
                huc.setRequestProperty("User-Agent", "edesign.pl EPP Client 0.1 alpha");
                huc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                huc.setRequestProperty("Content-Length", ""+command.length());

                // Wysyłam nagłówki
                huc.setDoOutput(true);
                huc.setSSLSocketFactory(getSSLContext().getSocketFactory());

                // Wysyłam zawartoć żšdania POST
                BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(
                huc.getOutputStream(), charset ) );
                bw.write(command);
                bw.close();

                // Pobieram odpowied serwera WWW na komendę EPP
                InputStream is = huc.getInputStream();
                BufferedReader bis = new BufferedReader( new InputStreamReader( is ) );
                String line = "";
                StringBuffer odp = new StringBuffer();

                while ( (line = bis.readLine()) != null)
                    odp.append( line );

                bis.close();

                System.out.println("ODPOWIEDZ NA KOMENDE:\n" + odp.toString() + "\n\n\n");
                huc.disconnect();

                // Usuń komentarz z linii poniżej - a błšd
                // nie wystšpi przy trzecim połšczeniu
                // Thread.currentThread().sleep(5000);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static SSLContext getSSLContext() {
        try {
            // load your key store as a stream and initialize a KeyStore
            /* String fileName = properties.getProperty("javax.net.ssl.trustStore"); */
            String fileName = "/home/kkolcz/IdeaProjects/powerhosting/ipakiet-customer-panel/src/main/webapp/WEB-INF/Resources/testowy_keystore.ImportKey";
            InputStream trustStream = new FileInputStream(fileName);
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());

            // if your store is password protected then declare it (it can be
            // null however)
            /* String trustPassword = properties.getProperty("javax.net.ssl.trustStorePassword"); */
            String trustPassword = "Power123"; 

            // load the stream to your store
            trustStore.load(trustStream, trustPassword.toCharArray());

            // initialize a trust manager factory with the trusted store
            TrustManagerFactory trustFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustFactory.init(trustStore);

            KeyManagerFactory keyFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyFactory.init(trustStore, trustPassword.toCharArray());

            // get the trust managers from the factory
            TrustManager[] trustManagers = trustFactory.getTrustManagers();
            KeyManager[] keyManagers = keyFactory.getKeyManagers();

            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(keyManagers, trustManagers, null);
            return sslContext;
        } catch (Exception e) {
            /* log.error(e.getMessage(), e); */
            throw new RuntimeException("Błąd podczas inicjalizacji bezpiecznego połączenia. Nie połączono", e);
        }
    }

}

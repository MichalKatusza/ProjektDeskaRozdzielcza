package dao;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.Lights;

import java.io.*;

/***
 * Klasa odpowiadaj¹ca za serializacjê stanów objektów œwiate³ do postaci XML oraz za ich zapis i odczyt.
 * Ta klasa implementuje interfjes Dao.
 */
public class XmlLightsDao implements Dao<Lights>{

    /***
     * Przeci¹¿ona metoda read() z interfejsu Dao, odczytuj¹ca stan(w³¹czone/wy³¹czone) objektów œwiate³ z pliku XML.
     */
    @Override
    public Lights read() throws IOException {
        File file = new File("lights_settings.xml");
        XmlMapper xmlMapper = new XmlMapper();
        String xml = inputStreamToString(new FileInputStream(file));
        return xmlMapper.readValue(xml, Lights.class);
    }

    /***
     * Przeci¹¿ona metoda write() z interfejsu Dao, zapisujaca stan(w³¹czone/wy³¹czone) objektów œwiate³ do pliku XML.
     */
    @Override
    public void write(Lights obj) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new File("lights_settings.xml"), obj);
    }

    /***
     * Funkcja konwertuj¹ca objekt typu InputStream do objeku typu String.
     * @param is Obiekt InputStream
     */
    public String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }
}

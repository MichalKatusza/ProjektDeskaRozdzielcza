package dao;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.Lights;

import java.io.*;

public class XmlLightsDao implements Dao<Lights>{

    @Override
    public Lights read() throws IOException {
        File file = new File("lights_settings.xml");
        XmlMapper xmlMapper = new XmlMapper();
        String xml = inputStreamToString(new FileInputStream(file));
        return xmlMapper.readValue(xml, Lights.class);
    }

    @Override
    public void write(Lights obj) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new File("lights_settings.xml"), obj);
    }

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

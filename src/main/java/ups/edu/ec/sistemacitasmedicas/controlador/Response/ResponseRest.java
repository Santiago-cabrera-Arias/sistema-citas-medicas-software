package ups.edu.ec.sistemacitasmedicas.controlador.Response;

import java.util.List;

public class ResponseRest <T> {

    private List<T> data;


    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }




}
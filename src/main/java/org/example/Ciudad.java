package org.example;

public class Ciudad {

    private String ciudad;
    private Double temperatura;
    private Long humedad;

    public Ciudad(String ciudad, Double temperatura, Long humedad) {
        this.ciudad = ciudad;
        this.temperatura = temperatura;
        this.humedad = humedad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Long getHumedad() {
        return humedad;
    }

    public void setHumedad(Long humedad) {
        this.humedad = humedad;
    }
}

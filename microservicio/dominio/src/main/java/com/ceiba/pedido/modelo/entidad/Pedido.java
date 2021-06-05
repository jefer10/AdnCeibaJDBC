package com.ceiba.pedido.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarPositivo;

@Getter
public class Pedido {

    private static final String SE_DEBE_INGRESAR_EL_VALOR_DE_ENVIO = "Se debe ingresar el  valor de envio";
    private static final String SE_DEBE_INGRESAR_EL_IVA = "Se debe ingresar el  valor del iva";
    private static final String SE_DEBE_INGRESAR_EL_TOTAL = "Se debe ingresar el valor del total del pedido";
    private static final String SE_DEBE_INGRESAR_LA_FECHA="se debe ingresar la fecha del pedido";
    private static final String SE_DEBE_INGRESAR_EL_CLIENTE_DEL_PEDIDO="se debe ingresar el numero del cliente del pedido";
    private static final String EL_VALOR_DEL_TOTAL_DEBE_SER_POSITIVO = "El valor deL pedido debe ser positivo";
    private static final String EL_VALOR_DEL_IVA_DEBE_SER_POSITIVO = "El valor deLl iva debe ser positivo";
    private static final String EL_VALOR_DEL_ENVIO_DEBE_SER_POSITIVO = "El valor deLl envio debe ser positivo";


    private Long id ;
    private LocalDateTime fecha;
    private Long clienteId;
    private Double iva;
    private Double valorEnvio;
    private Double total;

    public Pedido(Long id, LocalDateTime fecha, Long clienteId, Double iva, Double valorEnvio, Double total) {
        validarObligatorio(fecha, SE_DEBE_INGRESAR_LA_FECHA);
        validarObligatorio(clienteId, SE_DEBE_INGRESAR_EL_CLIENTE_DEL_PEDIDO);
        validarObligatorio(valorEnvio, SE_DEBE_INGRESAR_EL_VALOR_DE_ENVIO);
        validarObligatorio(iva, SE_DEBE_INGRESAR_EL_IVA );
        validarObligatorio(total,SE_DEBE_INGRESAR_EL_TOTAL);
        validarPositivo(iva,EL_VALOR_DEL_IVA_DEBE_SER_POSITIVO);
        validarPositivo(total, EL_VALOR_DEL_TOTAL_DEBE_SER_POSITIVO );
        //validarPositivo(valorEnvio, EL_VALOR_DEL_ENVIO_DEBE_SER_POSITIVO );

        this.id = id;
        this.fecha = fecha;
        this.clienteId = clienteId;
        this.iva = iva;
        this.valorEnvio = valorEnvio;
        this.total = total;
    }


}

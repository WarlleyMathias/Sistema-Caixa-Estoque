package Configuracao;

import javax.swing.*;
import java.text.*;
import java.awt.event.*;
import java.math.RoundingMode;

/**
 * Classe para criar campos formatados com valores em decimal Tanto para valores
 * simples, como para exibir mascaras monetarias ou porcentagem
 *
 */
@SuppressWarnings("serial")
public class DecimalField extends JFormattedTextField {

    /**
     * Constantes para definir o formato
     */
    public static final String NUMERO = "#,##0.00; -#,##0.00";
    public static final String REAL = "R$ #,##0.00;R$ -#,##0.00";
    public static final String PORCENTAGEM = "#,##0.00'%';-#,##0.00'%'";

    /**
     * Formato sendo utilizado
     */
    private DecimalFormat df;

    /**
     * Valor inserido no campo
     */
    private double dValue = 0.0;

    /**
     * Ultimo valor valido
     */
    private String oldValue = "";

    /**
     * String que sera exibida em caso de valor invalido ou fora do formato
     */
    public static final String ERRO = "Valor inválido";

    /**
     * Cria um novo objeto DecimalFormattedField, com o formato especificado
     *
     * @param formato Uma String que sera o formato (pattern) do DecimalFormat a
     * ser utilizado
     */
    public DecimalField(String formato) {
        super();

        df = new DecimalFormat();
        df.setRoundingMode(RoundingMode.UP);
        df.applyPattern(formato);

        this.setHorizontalAlignment(JTextField.RIGHT);

        setValue(oldValue);
        applyActions();
    }

    /**
     * Aplica um novo DecimalFormat
     */
    public void setDf(DecimalFormat df) {
        this.df = df;
        setValue("0.00");
        this.thisFocusGained(null);
        setText("0.00");
    }

    /**
     * Retorna o DecimalFormat sendo usado atualmente
     */
    public DecimalFormat getDf() {
        return df;
    }

    /**
     * Cria as acoes de focus para setar e verificar os valores digitados
     */
    private void applyActions() {

        /*this.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
         transferFocus();
         }
         });*/
        this.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent evt) {
                thisFocusLost(evt);
            }

            @Override
            public void focusGained(FocusEvent evt) {
                thisFocusGained(evt);
            }
        });

    }

    /**
     * Verifica se o valor digitado e valido, e insere os novos valores
     */
    public void thisFocusLost(FocusEvent evt) {
        String valor = getText();

        valor = valor.contains(",") ? valor.replace(".", "").replace(",", ".") : valor;

        if (!valor.equals("") && !valor.trim().isEmpty()) {
            oldValue = valor;
        }

        setValue(valor);
    }

    /**
     * Limpa o campo para que seja digitado novo valor
     */
    public void thisFocusGained(FocusEvent fe) {
        super.setText(getText().replace("R$", "").replace(" ", ""));
        normalText();
    }

    /**
     * Seta os valores no campo
     */
    private void setValue(String value) {

        if (value == null || value.equals("")) {
            value = "0.00";
        }

        try {
            dValue = arredondar(Double.parseDouble(value));
        } catch (Exception e) {
            /**
             * Aqui o valor e invalido, entao coloca novamente o valor antigo
             */
            value = oldValue;
        }

        showValue(value);

    }

    @Override
    public void setValue(Object value) {

        if (value == null || value.equals("")) {
            value = "0.00";
        }

        if (value instanceof Double) {
            double d = (Double) value;
            this.setText(String.format("%f", d));
        } else {
            this.setText(value.toString());
        }

    }

    /**
     * Mostra o valor formatado no padrao do DecimalFormat
     *
     * @param s valor informado no campo
     */
    public void showValue(String s) {

        if (s == null || s.equals("")) {
            s = "0.00";
        }

        try {
            super.setText(df.format(new java.math.BigDecimal(s)));
        } catch (Exception e) {
            /**
             * Valor invalido
             */
            super.setText(df.format(0.));
            dValue = Double.NaN;
        }
    }

    /**
     * Retorna o valor inserido no campo.
     *
     * @return dValue double value
     */
    public double getDoubleValue() {
        return dValue;
    }

    @Override
    public Object getValue() {
        return getDoubleValue();
    }


    /**
     * Volta o texto ao formato original
     */
    private void normalText() {
        this.setForeground(null);
    }

    @Override
    public void setText(String valor) {
        super.setText(valor);
        this.thisFocusLost(null);
    }

    /**
     * Arredondamento para corrigir possiveis diferenÃ§as em decimal do valor
     * exibido com o valor retornado
     */
    public double arredondar(double d) {
        if (d > 0) {
            return (Math.ceil((d * 100.0))) / 100.0;
        } else {
            return (Math.floor((d * 100.0))) / 100.0;
        }
    }

}

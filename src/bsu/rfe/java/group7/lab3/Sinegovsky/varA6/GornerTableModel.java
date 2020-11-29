package bsu.rfe.java.group7.lab3.Sinegovsky.varA6;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class GornerTableModel extends AbstractTableModel {

    private Double[] coefficients;
    private Double from;
    private Double to;
    private Double step;

    public GornerTableModel(Double from, Double to, Double step, Double[] coefficients) {
        this.from = from;
        this.to = to;
        this.step = step;
        this.coefficients = coefficients;
    }

    public Double getFrom() {
        return from;
    }

    public Double getTo() {
        return to;
    }

    public Double getStep() {
        return step;
    }

    public int getColumnCount() {
        return 2; // В данной модели два столбца
    }

    public int getRowCount() {
        // Вычислить количество точек между началом и концом отрезка исходя из шага табулирования
        return new Double(Math.ceil((to - from) / step)).intValue() + 1;
    }
    public Object getValueAt(int row, int col) {
        // Вычислить значение X как НАЧАЛО_ОТРЕЗКА + ШАГ * НОМЕР_СТРОКИ
        double x = from + step * row;
        if (col == 0) {
            return x;               // Если запрашивается значение 1-го столбца, то это X
        } else {
            Double result = 0.0;    // Значение многочлена
            return result;          // Вычисление значения в точке по схеме Горнера
        }
    }

    public String getColumnName(int col) {
        switch (col) {
            case 0:
                return "Значение X";            // Название 1-го столбца
            default:
                return "Значение многочлена";   // Название 2-го столбца
        }
    }
    public Class<?> getColumnClass(int col) {
        return Double.class;
    }
}
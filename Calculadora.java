/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacion9;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author USER
 */
public class Calculadora extends JFrame implements ActionListener {
    
    private JButton btnsuma, btnresta, btnmulti, btndiv, btnlimpiar, btnraiz, btnpotencia, btnsalir;
    private JTextField valor1, valor2, camporesultado;
    JLabel label1, label2;
    
    public void Controles(){
        Container contenedor = getContentPane();
        contenedor.setLayout( new FlowLayout());
        label1 = new JLabel("Numero 1");
        contenedor.add(label1);
        valor1 = new JTextField(10);
        contenedor.add(valor1);
        label2 = new JLabel("Numero 2");
        contenedor.add(label2);
        valor2 = new JTextField(10);
        contenedor.add(valor2);
        btnsuma = new JButton("+");
        contenedor.add(btnsuma);
        btnsuma.addActionListener(this);
        btnresta = new JButton("-");
        contenedor.add(btnresta);
        btnresta.addActionListener(this);
        btnmulti = new JButton("x");
        contenedor.add(btnmulti);
        btnmulti.addActionListener(this);
        btndiv = new JButton("/");
        btndiv.addActionListener(this);
        contenedor.add(btndiv);
        btnraiz = new JButton("Ra");
        btnraiz.addActionListener(this);
        contenedor.add(btnraiz);
        btnpotencia = new JButton("Pot");
        btnpotencia.addActionListener(this);
        contenedor.add(btnpotencia);
        camporesultado = new JTextField(10);
        contenedor.add(camporesultado);
        btnlimpiar = new JButton("Limpiar");
        btnlimpiar.addActionListener(this);
        contenedor.add(btnlimpiar);
        btnsalir = new JButton("Salir");
        btnsalir.setBackground(Color.red);
        contenedor.add(btnsalir);
        btnsalir.addActionListener(this);
        
    }
    
    public Calculadora(){
        //con super invocamos al contructor de la clase jframe 
        super("Calculadora");
        
        Controles();
        
        setSize(380,200);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent e){
        double num1,num2,resu;
        String resultado;
        if(e.getSource()==btnsuma){
            if(valor1.getText().equals("") || valor2.getText().equals("")){
                JOptionPane.showMessageDialog(null, "los datos no estan completos",
                        "Error", JOptionPane.WARNING_MESSAGE);               
            }
            else{
                num1 = Double.parseDouble(valor1.getText());
                num2 = Double.parseDouble(valor2.getText());
                resu = num1+num2;
                resultado = String.valueOf(resu);
                camporesultado.setText(resultado);
            }
        }
        if(e.getSource()==btnresta){
            if(valor1.getText().equals("") || valor2.getText().equals("")){
                JOptionPane.showMessageDialog(null, "los datos no estan completos",
                        "Error", JOptionPane.WARNING_MESSAGE);               
            }
            else{
                num1 = Double.parseDouble(valor1.getText());
                num2 = Double.parseDouble(valor2.getText());
                resu = num1-num2;
                resultado = String.valueOf(resu);
                camporesultado.setText(resultado);
            }      
        }
        if(e.getSource()==btnmulti){
            if(valor1.getText().equals("") || valor2.getText().equals("")){
                JOptionPane.showMessageDialog(null, "los datos no estan completos",
                        "Error", JOptionPane.WARNING_MESSAGE);               
            }
            else{
                num1 = Double.parseDouble(valor1.getText());
                num2 = Double.parseDouble(valor2.getText());
                resu = num1*num2;
                resultado = String.valueOf(resu);
                camporesultado.setText(resultado);
            }
        }
        if(e.getSource()==btndiv){
        if(valor1.getText().equals("") || valor2.getText().equals(""))
         {
          JOptionPane.showMessageDialog(null, "Los datos no están Incompletos",
          "Error",JOptionPane.ERROR_MESSAGE);
         }
        else{
            num1 = Double.parseDouble(valor1.getText());
            num2 = Double.parseDouble(valor2.getText());
            try{
                resu = num1/num2;
                resultado = String.valueOf(resu);
                camporesultado.setText(resultado);
            }catch(ArithmeticException ex){
                JOptionPane.showMessageDialog(null,"Division entre cero NO PERMITIDA!",
                        "Error",JOptionPane.ERROR_MESSAGE);
            }
        }            
        }
        if(e.getSource()==btnpotencia){
            if(valor1.getText().equals("") ||  valor2.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Los datos no están completos",
          "Error",JOptionPane.ERROR_MESSAGE); 
            }
            else{
                num1 = Double.parseDouble(valor1.getText());
                num2 = Double.parseDouble(valor2.getText());
                resu = Math.pow(num1, num2);
                resultado = String.valueOf(resu);
                camporesultado.setText(resultado);
            }
        }
        if(e.getSource()==btnraiz){
          if(valor1.getText().equals("") ){
          JOptionPane.showMessageDialog(null, "Dejaste en blanco el campo.",
          "Error",JOptionPane.ERROR_MESSAGE); 
         }
          else{
              num1=Double.parseDouble(valor1.getText());
              if(num1>=0){
                  resu=Math.sqrt(num1);
                  resultado = String.valueOf(resu);
                  camporesultado.setText(resultado);
              }
              else{
                  JOptionPane.showMessageDialog(null, "Raiz negativa",
                          "Error", JOptionPane.ERROR_MESSAGE);
              }
          }
        }
        if(e.getSource()==btnlimpiar){
            valor1.setText("");
            valor2.setText("");
            camporesultado.setText("");    
        }
        if(e.getSource()==btnsalir){
            System.exit(0);
        }
        
        
        
    }
    
    public static void main(String[] args){
        JFrame.setDefaultLookAndFeelDecorated(true);
        Calculadora calc = new Calculadora();
        calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    
    
    
    
}

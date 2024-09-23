/****************
 * This code was automatically generated by lwm2m_codegen.
 ****************/
package org.eclipse.leshan.client.demo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
import java.util.List;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

import org.eclipse.leshan.client.servers.ServerIdentity;
import org.eclipse.leshan.client.resource.BaseInstanceEnabler;
import org.eclipse.leshan.core.model.ResourceModel.Type;
import org.eclipse.leshan.core.model.ObjectModel;
import org.eclipse.leshan.core.node.LwM2mResource;
import org.eclipse.leshan.core.request.argument.Arguments;
import org.eclipse.leshan.core.response.ExecuteResponse;
import org.eclipse.leshan.core.response.ReadResponse;
import org.eclipse.leshan.core.response.WriteResponse;
import org.eclipse.leshan.core.util.NamedThreadFactory;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.WindowConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.EventQueue;

public class Wallet extends BaseInstanceEnabler {
    static final int OBJECT_ID_WALLET = 33009;
    static final int OBJECT_ID = 33009;
    // Static values for resource items
    private static final int RES_COIN_BALANCE = 30042;
    private static final int RES_ROOMCONTROL_NAME = 30016;
    private static final List<Integer> supportedResources =
     Arrays.asList(
             RES_COIN_BALANCE
           , RES_ROOMCONTROL_NAME
           );
    // Variables storing current values.

    private long vCoinBalance = 0;
   private JLabel glCoinBalance;
   private JLabel gvCoinBalance;
   private JTextField tfCoinBalance;

    private String vRoomcontrolName = "";
   private JLabel glRoomcontrolName;
   private JLabel gvRoomcontrolName;
   private JTextField tfRoomcontrolName;
   private JFrame guiFrame;

  public Wallet() {
      //  Automatically generated GUI code.
    guiFrame = new JFrame();
    guiFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    guiFrame.setTitle("Wallet");

  // Coin Balance
    glCoinBalance = new JLabel();
    glCoinBalance.setText("Coin Balance");
    gvCoinBalance = new JLabel();
    gvCoinBalance.setText("");
    tfCoinBalance = new JTextField();
    tfCoinBalance.addActionListener(new java.awt.event.ActionListener() {
       public void actionPerformed(java.awt.event.ActionEvent evt) {
           String sValue = (String)tfCoinBalance.getText();
           setCoinBalance(Long.valueOf(sValue));
       }
     });

  // RoomControl Name
    glRoomcontrolName = new JLabel();
    glRoomcontrolName.setText("RoomControl Name");
    gvRoomcontrolName = new JLabel();
    gvRoomcontrolName.setText("");
    tfRoomcontrolName = new JTextField();
    tfRoomcontrolName.addActionListener(new java.awt.event.ActionListener() {
       public void actionPerformed(java.awt.event.ActionEvent evt) {
           String sValue = (String)tfRoomcontrolName.getText();
           setRoomcontrolName(String.valueOf(sValue));
       }
     });

  // Create layout of labels, inputs and values.
   GridLayout layout = new GridLayout(0,3,10,10);
   guiFrame.getContentPane().setLayout(layout);
   Container guiPane = guiFrame.getContentPane();
   guiPane.add(glCoinBalance);
   guiPane.add(tfCoinBalance);
    guiPane.add(gvCoinBalance);
   guiPane.add(glRoomcontrolName);
   guiPane.add(tfRoomcontrolName);
    guiPane.add(gvRoomcontrolName);
  guiFrame.pack();
  // Code to make the frame visible.
  java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
         guiFrame.setVisible(true);
      }
    });
  }

  @Override
  public synchronized ReadResponse read(ServerIdentity identity, int resourceId) {
    switch (resourceId) {
    case RES_COIN_BALANCE:
         return ReadResponse.success(resourceId, vCoinBalance);
    case RES_ROOMCONTROL_NAME:
         return ReadResponse.success(resourceId, vRoomcontrolName);
    default:
      return super.read(identity, resourceId);
    }
  }

  @Override
  public WriteResponse write(ServerIdentity identity, boolean replace, int resourceId, LwM2mResource value) {
    switch (resourceId) {
    case RES_COIN_BALANCE:
        // vCoinBalance = (Long) value.getValue();
        // fireResourceChange(resourceId);
        setCoinBalance((Long) value.getValue());
        return WriteResponse.success();
    case RES_ROOMCONTROL_NAME:
        // vRoomcontrolName = (String) value.getValue();
        // fireResourceChange(resourceId);
        setRoomcontrolName((String) value.getValue());
        return WriteResponse.success();
    default:
      return super.write(identity, replace, resourceId,value);
    }
  }

  @Override
  public synchronized ExecuteResponse execute(ServerIdentity identity, int resourceId, Arguments arguments) {
    switch (resourceId) {
    default:
      return super.execute(identity, resourceId,arguments);
    }
  }

  @Override
  public List<Integer> getAvailableResourceIds(ObjectModel model) {
     return supportedResources;
  }

  private synchronized void setCoinBalance(long value) {
    if (vCoinBalance != value) {
       vCoinBalance = value;
 gvCoinBalance.setText(Long.toString(vCoinBalance));
       fireResourceChange(RES_COIN_BALANCE);
    }
  }

  private synchronized void setRoomcontrolName(String value) {
    if (vRoomcontrolName != value) {
       vRoomcontrolName = value;
 gvRoomcontrolName.setText(vRoomcontrolName);
       fireResourceChange(RES_ROOMCONTROL_NAME);
    }
  }

}

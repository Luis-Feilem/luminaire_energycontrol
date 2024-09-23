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

public class DemandResponse extends BaseInstanceEnabler {
    static final int OBJECT_ID_DEMAND_RESPONSE = 33002;
    static final int OBJECT_ID = 33002;
    // Static values for resource items
    private static final int RES_TOTAL_ALLOWED_PEAK_ROOM_POWER = 30005;
    private static final List<Integer> supportedResources =
     Arrays.asList(
             RES_TOTAL_ALLOWED_PEAK_ROOM_POWER
           );
    // Variables storing current values.

  // 0..500
    private int vTotalAllowedPeakRoomPower = 300;
   private JLabel glTotalAllowedPeakRoomPower;
   private JLabel gvTotalAllowedPeakRoomPower;
   private JTextField tfTotalAllowedPeakRoomPower;
   private JFrame guiFrame;

  public DemandResponse() {
      //  Automatically generated GUI code.
    guiFrame = new JFrame();
    guiFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    guiFrame.setTitle("Demand Response");

  // Total Allowed Peak Room Power
    glTotalAllowedPeakRoomPower = new JLabel();
    glTotalAllowedPeakRoomPower.setText("Total Allowed Peak Room Power");
    gvTotalAllowedPeakRoomPower = new JLabel();
    gvTotalAllowedPeakRoomPower.setText(Integer.toString(vTotalAllowedPeakRoomPower));
    tfTotalAllowedPeakRoomPower = new JTextField();
    tfTotalAllowedPeakRoomPower.addActionListener(new java.awt.event.ActionListener() {
       public void actionPerformed(java.awt.event.ActionEvent evt) {
           String sValue = (String)tfTotalAllowedPeakRoomPower.getText();
           setTotalAllowedPeakRoomPower(Integer.valueOf(sValue));
       }
     });

  // Create layout of labels, inputs and values.
   GridLayout layout = new GridLayout(0,3,10,10);
   guiFrame.getContentPane().setLayout(layout);
   Container guiPane = guiFrame.getContentPane();
   guiPane.add(glTotalAllowedPeakRoomPower);
   guiPane.add(tfTotalAllowedPeakRoomPower);
    guiPane.add(gvTotalAllowedPeakRoomPower);
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
    case RES_TOTAL_ALLOWED_PEAK_ROOM_POWER:
         return ReadResponse.success(resourceId, vTotalAllowedPeakRoomPower);
    default:
      return super.read(identity, resourceId);
    }
  }

  @Override
  public WriteResponse write(ServerIdentity identity, boolean replace, int resourceId, LwM2mResource value) {
    switch (resourceId) {
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

  // Called before the object is registered, don't fire.
  public void configure(int peakroompower) {
      vTotalAllowedPeakRoomPower = peakroompower;
 gvTotalAllowedPeakRoomPower.setText(Integer.toString(vTotalAllowedPeakRoomPower));  }

  private synchronized void setTotalAllowedPeakRoomPower(int value) {
    if (vTotalAllowedPeakRoomPower != value) {
       vTotalAllowedPeakRoomPower = value;
 gvTotalAllowedPeakRoomPower.setText(Integer.toString(vTotalAllowedPeakRoomPower));
       fireResourceChange(RES_TOTAL_ALLOWED_PEAK_ROOM_POWER);
    }
  }

}

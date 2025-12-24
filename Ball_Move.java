import java.awt.*;
import java.awt.event.*;


class Ball_Move extends Frame implements MouseMotionListener,WindowListener{
    int circleX = 400, circleY = 400,circleradius = 20;
    TextField text = new TextField();

    Ball_Move(){
        addMouseMotionListener(this);
        addWindowListener(this);

        setSize(800,800);
        setLayout(null);
        setTitle("Ball Game");
        setVisible(true);
        
        
    }

    public void paint(Graphics g){
            super.paint(g);
            g.setColor(Color.BLUE);
            g.fillOval(circleX,circleY,3*circleradius,3*circleradius);
            text.setText("Ball Game (move your cursor towards the ball protect it from going out the screen)");


        }

public void mouseDragged(MouseEvent e){

}

public void mouseMoved(MouseEvent e){
    int x = e.getX();
    int y = e.getY();

    if(x < circleX+circleradius*3){
        circleX++;
    }
    if(x > circleX+circleradius*3){
        circleX--;
    }
    if(y < circleY+circleradius*3){
            circleY++;
        }
    if(y > circleY+circleradius*3){
            circleY--;
        }

    repaint();    
}

    

public static void main (String[] args){
    Ball_Move b1 = new Ball_Move();

}

@Override
public void windowOpened(WindowEvent e) {}

@Override
public void windowClosing(WindowEvent e) {
    System.exit(0);
}

@Override
public void windowClosed(WindowEvent e) {}

@Override
public void windowIconified(WindowEvent e) {}

@Override
public void windowDeiconified(WindowEvent e) {}

@Override
public void windowActivated(WindowEvent e) {}

@Override
public void windowDeactivated(WindowEvent e) {}


}
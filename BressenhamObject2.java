import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class BressenhamObject2 extends JFrame implements MouseListener{
	int x1,y1,x2,y2,r;
	Graphics g;
	BressenhamObject2(){
		setTitle("Bressenham Circle");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		addMouseListener(this);
		g=getGraphics();	
		
	}
	
	public void mouseClicked(MouseEvent e){
		x1=e.getX();
		y1=e.getY();
		
		g.setColor(Color.red);
		DDA(x1-50,y1-50,x1+50,y1+50);
		DDA(x1+50,y1-50,x1-50,y1+50);
		
		g.setColor(Color.magenta);
		bressenhamCircleAlgo(x1-50,y1-50,20);
		bressenhamCircleAlgo(x1-50,y1+50,20);
		bressenhamCircleAlgo(x1+50,y1-50,20);
		bressenhamCircleAlgo(x1+50,y1+50,20);
		
		double teta=Math.toRadians(22.5);
		double t1=50+(50*(Math.tan(teta)));
		
		g.setColor(Color.black);
		DDA(x1,y1-(int)t1,x1,y1+(int)t1);
		DDA(x1-(int)t1,y1,x1+(int)t1,y1);
		
		g.setColor(Color.blue);
		bressenhamCircleAlgo(x1-((int)t1+20),y1,20);
		bressenhamCircleAlgo(x1+((int)t1+20),y1,20);
		bressenhamCircleAlgo(x1,y1-((int)t1+20),20);
		bressenhamCircleAlgo(x1,y1+((int)t1+20),20);
		
		
		
	}
	
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	
	
	public void bressenhamCircleAlgo(int xc,int yc, int r){
		int x=0;
		int y=r;
		int d=3-2*r;
		while(x<=y){
			putCircle(xc,yc,x,y);
			if(d<0){
				d=d+4*x+6;
			}
			else{
				d=d+4*(x-y)+10;
				y--;
			}
			x++;
			
		}
			
	}
	
	public void DDA(int x1,int y1,int x2,int y2){
		int dx,dy;
		double steps,xinc,yinc,x,y;
		dx=x2-x1;
		dy=y2-y1;
		
		
		if(Math.abs(dx)>Math.abs(dy)){
			steps=Math.abs(dx);
		}
		else{
			steps=Math.abs(dy);
		}
	xinc=dx/steps;
	yinc=dy/steps;
	
	x=x1;
	y=y1;
	
	g.drawLine((int)Math.round(x),(int)Math.round(y),(int)Math.round(x),(int)Math.round(y));
	
	for(int i=1;i<=steps;i++){
		x=x+xinc;
		y=y+yinc;
		g.drawLine((int)Math.round(x),(int)Math.round(y),(int)Math.round(x),(int)Math.round(y));
		
	}
	
	} 
	
	public void putCircle(int h,int k,int x,int y){
		g.drawLine(h+x,k+y,h+x,k+y);
		g.drawLine(h+x,k-y,h+x,k-y);
		g.drawLine(h-x,k+y,h-x,k+y);
		g.drawLine(h-x,k-y,h-x,k-y);
		g.drawLine(h+y,k+x,h+y,k+x);
		g.drawLine(h+y,k-x,h+y,k-x);
		g.drawLine(h-y,k+x,h-y,k+x);
		g.drawLine(h-y,k-x,h-y,k-x);
		
		
	}
	
	public static void main(String args[]){
		
		BressenhamObject2 ob =new BressenhamObject2();
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
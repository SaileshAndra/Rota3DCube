

import java.util.*;

public class Rota3DCube {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if(args.length < 5)
		{
			System.err.print("input not applicable. Try again");
		}
		
		
		
		double x = Double.parseDouble(args[0]);
		double y = Double.parseDouble(args[1]);
		double z = Double.parseDouble(args[2]);
		int degree = Integer.parseInt(args[3]);
		
	String axis = args[4];
	
	
	switch(axis.toLowerCase())
	{
	case("x-axis"):
	{
		double[][] intrans = {{1,0,0,0},
				  			  {0,1,0,0},
				  			  {0,0,1,0},
				  			  {-x,-y,-z,1}};

		double[][] rotax = {{1,0,0,0},
							{0,Math.cos(Math.toRadians(degree)),Math.sin(Math.toRadians(degree)),0},
							{0,-Math.sin(Math.toRadians(degree)),Math.cos(Math.toRadians(degree)),0},
							{0,0,0,1}};

		double[][] trans = {{1,0,0,0},
	            	 		{0,1,0,0},
	            	 		{0,0,1,0},
	            	 		{x,y,z,1}};
	
		double[][] matrix = {{0,0,0,1},
		         			 {1,0,0,1},
							 {1,0,1,1},
							 {0,0,1,1},
							 {0,1,1,1},
							 {1,1,1,1},
							 {1,1,0,1},
							 {0,1,0,1}};
	
	//multiply intrans and rotax
	double[][] mulmat = new double[4][4];
	
	for(int i = 0; i < 4; i++)
	{
		for(int j =0; j < 4; j++)
		{
			for(int k = 0; k < 4; k++)
			{
				mulmat[i][j] += intrans[i][k] * rotax[k][j];
			}
		}
	}
	
	//multiply mulmat with trans
	double[][] calcmatrix  = new double[4][4];
	
	for(int i = 0; i < 4; i++)
	{
		for(int j =0; j < 4; j++)
		{
			for(int k = 0; k < 4; k++)
			{
				calcmatrix[i][j] += mulmat[i][k] * trans[k][j];
			}
		}
	}
	
	
	
	
	
	
	
	//multiply calcmatrix with the matrix
	double[][] finalmatrix = new double[8][4];
	
	for(int i = 0; i < 8; i++)
	{
		for(int j =0; j < 4; j++)
		{
			for(int k = 0; k < 4; k++)
			{
			   finalmatrix[i][j] += matrix[i][k] * calcmatrix[k][j];
			}
		}
	}
System.out.println("Rotate unit cube "+String.format("%.6f",Math.toRadians(degree))+" radians about x-axis at point ("+String.format("%.6f",x)+", "+String.format("%.6f",y)+", "+String.format("%.6f",z)+")");
	System.out.println("       Initial Vertices               Rotated Vertices");
	for(int i  = 0; i < 8;i++)
	{
		
		int j =0;
		
			System.out.print(i+": "+String.format("%.6f",matrix[i][j])+" "+String.format("%.6f",matrix[i][j+1])+" "+String.format("%.6f",matrix[i][j+2])+" ");
			System.out.print("  "+String.format("%.6f", finalmatrix[i][j]) + " "+String.format("%.6f", finalmatrix[i][j+1]) + " "+String.format("%.6f", finalmatrix[i][j+2]) + " ");
		
		System.out.println();
	}
	break;
	}
	
	
	case("y-axis"):
	{
		
		double[][] intrans = {{1,0,0,0},
	  			  {0,1,0,0},
	  			  {0,0,1,0},
	  			  {-x,-y,-z,1}};



double[][] rotay = {
					{Math.cos(Math.toRadians(degree)),0,-Math.sin(Math.toRadians(degree)),0},
					{0,1,0,0},
					{Math.sin(Math.toRadians(degree)),0,Math.cos(Math.toRadians(degree)),0},
					{0,0,0,1}};

double[][] trans = {{1,0,0,0},
  	 		{0,1,0,0},
  	 		{0,0,1,0},
  	 		{x,y,z,1}};

double[][] matrix = {{0,0,0,1},
   			 		{1,0,0,1},
				 {1,0,1,1},
				 {0,0,1,1},
				 {0,1,1,1},
				 {1,1,1,1},
				 {1,1,0,1},
				 {0,1,0,1}};

//multiply intrans and rotax
double[][] mulmat = new double[4][4];

for(int i = 0; i < 4; i++)
{
for(int j =0; j < 4; j++)
{
for(int k = 0; k < 4; k++)
{
	mulmat[i][j] += intrans[i][k] * rotay[k][j];
}
}
}

//multiply mulmat with trans
double[][] calcmatrix  = new double[4][4];

for(int i = 0; i < 4; i++)
{
for(int j =0; j < 4; j++)
{
for(int k = 0; k < 4; k++)
{
	calcmatrix[i][j] += mulmat[i][k] * trans[k][j];
}
}
}







//multiply calcmatrix with the matrix
double[][] finalmatrix = new double[8][4];

for(int i = 0; i < 8; i++)
{
for(int j =0; j < 4; j++)
{
for(int k = 0; k < 4; k++)
{
 finalmatrix[i][j] += matrix[i][k] * calcmatrix[k][j];
}
}
}

System.out.println("Rotate unit cube "+String.format("%.6f",Math.toRadians(degree))+" radians about y-axis at point ("+String.format("%.6f",x)+", "+String.format("%.6f",y)+", "+String.format("%.6f",z)+")");

System.out.println("       Initial Vertices               Rotated Vertices");
for(int i  = 0; i < 8;i++)
{

int j =0;

System.out.print(i+": "+String.format("%.6f",matrix[i][j])+" "+String.format("%.6f",matrix[i][j+1])+" "+String.format("%.6f",matrix[i][j+2])+" ");
System.out.print("  "+String.format("%.6f", finalmatrix[i][j]) + " "+String.format("%.6f", finalmatrix[i][j+1]) + " "+String.format("%.6f", finalmatrix[i][j+2]) + " ");

System.out.println();
}

break;		
}
	case("z-axis"):
	{
		
		
		double[][] intrans = {{1,0,0,0},
	  			  {0,1,0,0},
	  			  {0,0,1,0},
	  			  {-x,-y,-z,1}};


double[][] rotaz = {
		{Math.cos(Math.toRadians(degree)),Math.sin(Math.toRadians(degree)),0,0},
		{-Math.sin(Math.toRadians(degree)),Math.cos(Math.toRadians(degree)),0,0},
		{0,0,1,0},
		{0,0,0,1}};

double[][] trans = {{1,0,0,0},
  	 		{0,1,0,0},
  	 		{0,0,1,0},
  	 		{x,y,z,1}};

double[][] matrix = {{0,0,0,1},
   			 {1,0,0,1},
				 {1,0,1,1},
				 {0,0,1,1},
				 {0,1,1,1},
				 {1,1,1,1},
				 {1,1,0,1},
				 {0,1,0,1}};

//multiply intrans and rotax
double[][] mulmat = new double[4][4];

for(int i = 0; i < 4; i++)
{
for(int j =0; j < 4; j++)
{
for(int k = 0; k < 4; k++)
{
	mulmat[i][j] += intrans[i][k] * rotaz[k][j];
}
}
}

//multiply mulmat with trans
double[][] calcmatrix  = new double[4][4];

for(int i = 0; i < 4; i++)
{
for(int j =0; j < 4; j++)
{
for(int k = 0; k < 4; k++)
{
	calcmatrix[i][j] += mulmat[i][k] * trans[k][j];
}
}
}







//multiply calcmatrix with the matrix
double[][] finalmatrix = new double[8][4];

for(int i = 0; i < 8; i++)
{
for(int j =0; j < 4; j++)
{
for(int k = 0; k < 4; k++)
{
 finalmatrix[i][j] += matrix[i][k] * calcmatrix[k][j];
}
}
}

System.out.println("Rotate unit cube "+String.format("%.6f",Math.toRadians(degree))+" radians about z-axis at point ("+String.format("%.6f",x)+", "+String.format("%.6f",y)+", "+String.format("%.6f",z)+")");

System.out.println("       Initial Vertices               Rotated Vertices");
for(int i  = 0; i < 8;i++)
{

int j =0;

System.out.print(i+": "+String.format("%.6f",matrix[i][j])+" "+String.format("%.6f",matrix[i][j+1])+" "+String.format("%.6f",matrix[i][j+2])+" ");
System.out.print("  "+String.format("%.6f", finalmatrix[i][j]) + " "+String.format("%.6f", finalmatrix[i][j+1]) + " "+String.format("%.6f", finalmatrix[i][j+2]) + " ");

System.out.println();
}

break;		
	
	}
	
	
	}
	
		
		
	}
	}


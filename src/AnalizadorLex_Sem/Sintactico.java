package AnalizadorLex_Sem;

import java.util.Stack;

public class Sintactico {
	
	private String matriz[][]={//si se agregan datos a la tabla se tienen que modificar la cabezera para la entrada
			
		   	{ " ", 	"id",	"int",	"float",	"char",		"num",		",",		 ";",		"=",		"+",		"-",		"*",		"/",		"(",		")",		"$",		"p",		"Tipo",		"V",		"A",   		 "E",		"T",		"F"	   },
		   	
			{"q0",	"q7",	"q4",	  "q5",	     "q6",		"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"q1",		 "q2",	    "Error",	"q3",		"Error",	"Error",    "Error"},
			
			{"q1",	"q7","Error", "Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"p0",		"q1",	"Error",	"Error",	"q3",	"Error",	"Error", 	"Error"},
			
			{"q2",	"q8",	"Error", "Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error"},
			
			{"q3",	"p2","Error", "Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"p2",		"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error"},
			
			{"q4",	"p3",	"Error",  "Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error"},
			
			{"q5",	"p4",	"Error",  "Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error"},
			
			{"q6",	"p5",	"Error",  "Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error"},
			
			{"q7",	"Error","Error",  "Error",	"Error",	"Error",	"Error",	"Error",	"q9",     	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error"},
			
			{"q8",	"Error","Error",  "Error",	"Error",	"Error",	"q11",	    "q12",	   "Error",		"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"q10",		"Error",	"Error",	"Error",	"Error"},
			
			{"q9",	"q17",	"Error",  "Error",	"Error",	"q18"  ,	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"q16",		"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"q13"  ,	"q14"  ,	"q15"},
			
			{"q10",	"p1","Error",  "Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"p1",		"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error"},
            
			{"q11",	"q19",	"Error",  "Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error"},
            
			{"q12",	"q7",	"q4",	  "q5",		"q6",		"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"q20",		"q2",		"Error",	"q3",		"Error",	"Error",	"Error"},
            
			{"q13",	"Error","Error",  "Error",	"Error",	"Error",	"Error",	"q21",	    "Error",	"q22",		"q23",		"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error"},
            
			{"q14",	"Error","Error",  "Error",	"Error",	"Error",	"Error",	"p11",		"Error",	"p11",		"p11",		"q24",		"q25",		"Error",	"p11",	    "Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error"},
            
			{"q15",	"Error","Error",  "Error",	"Error",	"Error",	"Error",	"p14",		"Error",	"p14",		"p14",		"p14",		"p14",  	"Error",	"p14",		"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error"},
			
			{"q16",	"q17",	"Error",  "Error",	"Error",	"q18",   	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"q16",   	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"q26",		"q14",		"q15"  },
			
			{"q17",	"Error","Error",  "Error",	"Error",	"Error",	"Error",	"p14",		"Error",	"p16",		"p16",		"p16",		"p16",		"Error",	"p16",		"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error"},
			
			{"q18",	"Error","Error",  "Error",	"Error",	"P15",    "Error",		"p17",		"Error",	"p17",		"p17",		"p17",		"p17",		"Error",	"p17",		"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error"},
			
			{"q19",	"Error","Error",  "Error",	"Error",	"Error",	"q11",		"q12",		"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"q27",		"Error",	"Error",	"Error",	"Error"},
            
			{"q20",	"p7","Error",  "Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	 "p7",		"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error"},
            
			{"q21",	"p8","Error",  "Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"p8",		"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error"},
			
			{"q22",	"q17",	"Error",  "Error",	"Error",	"q18",		"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"q16",		"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"q28",		"q15"},
			
			{"q23",	"q17",	"Error",  "Error",	"Error",	"q18",		"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"q16",		"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"q29",		"q15"},
			
			{"q24",	"q17",	"Error",  "Error",	"Error",	"q18",		"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"q16",		"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"q30"},
			
			{"q25",	"q17",	"Error",  "Error",	"Error",	"q18",		"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"q16",		"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"q31"},
			
			{"q26",	"Error","Error",  "Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"q22",		"q23",		"Error",	"Error",	"Error",	"q32",		"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error"},
            
			{"q27",	"p6","Error",  "Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"p6",		"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error"},
			
			{"q28",	"Error","Error",  "Error",	"Error",	"Error",	"Error",	"p9",		"Error",	"p9",		"p9",		"q24",		"q25",		"Error",	"p9",		"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error"},
			
			{"q29",	"Error","Error",  "Error",	"Error",	"Error",	"Error",	"p10",		"Error",	"p10",		"p10",		"q24",		"q25",		"Error",	"p10",		"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error"},
			
			{"q30",	"Error","Error",  "Error",	"Error",	"Error",	"Error",	"p12",		"Error",	"p12",		"p12",		"p12",		"p12",		"Error",	"p12",		"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error"},
			
			{"q31",	"Error","Error",  "Error",	"Error",	"Error",	"Error",	"p13",		"Error",	"p13",		"p13",		"p13",		"p13",		"Error",	"p13",		"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error"},
			
			{"q32",	"Error","Error",  "Error",	"Error",	"Error",	"Error",	"p15",		"Error",	"p15",		"p15",		"p15",		"p15",		"Error",	"p15",		"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error",	"Error"},
			
		}
			;
	
	
	//int var1 , var2 ; var1 = var2 ;

	Stack<String> pila=new Stack<String>();
	String pala[]= new String [18];
	int act=1, act2, nl;
	int columna, renglon, palab;
	String cadinter="";
	String pilaS;
	String p[]={"p","Tipo,id,V","A","int","float","char",",,id,V",";,p","id,=,E,;"
			,"E,+,T","E,-,T","T","T,*,F","T,/,F","F","(,E,)", "id", "num"
			};
	
	String ter[]={"id","int","float","char","num",",", ";","=","+", "-", "*", "/", "(", ")", "$", "p", "Tipo", "V", "A",  "E", "T", "F"};
	boolean Fin=true;
	Stack<String> pilaerror=new Stack<String>();
	
        //
        
	public String metodo(Stack<String> ana)
	{
		nl=1;
		pilaS="$ q0 \n";
		pila.push("$");
		pila.push("q0");
		ana.push("$");
		while(Fin)
		{
			columna=0; renglon=0; palab=0;
			pala= new String [18];
			if(ana.elementAt(act2).compareTo("\n")!=0)
			{

				System.out.println(ana.elementAt(act2));
				try
				{
					for(int i=0;matriz[0][i].compareTo(ana.elementAt(act2))!=0;i++)
					{
						columna++;
					}
					System.out.println(pila.elementAt(act));
					
					for(int i=0;matriz[i][0].compareTo(pila.elementAt(act))!=0;i++)
					{
						renglon++;
					}
					cadinter=matriz[renglon][columna];
				}
				catch (Exception e) 
				{
					cadinter="Error";
				}
				String cad="";
				System.out.println(cadinter);
				if(cadinter.compareTo("Error")==0)
				{
					pilaS+="\n"+cadinter+"";
					pilaerror.push((pilaerror.size()+1)+".-Error Sintactico en "+ ana.elementAt(act2)+" numero de linea "+nl);
					return pilaS;
				}
				if((cadinter.charAt(0)+"").compareTo("p")!=0)
				{
					pila.push(matriz[0][columna]);
					pila.push(matriz[renglon][columna]);
					act2++;
				}
				else
				{
					int ps=0;
					if(matriz[renglon][columna].length()==2)
					{
						ps=Integer.parseInt(matriz[renglon][columna].charAt(1)+"");
					}
					else
					{
						if(matriz[renglon][columna].length()==3)
						{
							ps=Integer.parseInt(matriz[renglon][columna].charAt(2)+"");
							ps+=Integer.parseInt(matriz[renglon][columna].charAt(1)+"")*10;
						}
						else
						{
							if(matriz[renglon][columna].length()==4)
							{
								ps=Integer.parseInt(matriz[renglon][columna].charAt(3)+"");
								ps+=Integer.parseInt(matriz[renglon][columna].charAt(2)+"")*10;
								ps+=Integer.parseInt(matriz[renglon][columna].charAt(1)+"")*100;
							}
						}
					}
					
					if(ps!=6)
					{
						cadinter=p[ps];
						for(int i=0;cadinter.length()>i;i++)
						{
							if(cadinter.charAt(i)!=',')
							{
								cad+=cadinter.charAt(i);
							}
							else
							{
								pala[palab]=cad;
								palab++;
								act++;
								System.out.print(cad);
								cad="";
							}
						}
						pala[palab]=cad;
						System.out.println(cad);
						palab++;
					}
					else
					{
						pala[0]=",";
						pala[1]="id";
						pala[2]="V";
						palab+=3;
					}
					
					System.out.println(palab);
					int pan=0;
					boolean ban=true, ban2=false;
					for(int i=0;palab>i;i++)
					{
						if(pila.elementAt(pila.size()-(2*(i+1))).compareTo(pala[palab-i-1])==0)
						{
							System.out.print(pala[palab-i-1]+" ");
							pan=2*(i+1);
							System.out.print(pan+" ");
						}
					}
					System.out.println();
					System.out.println();
					ban=false;
					for(int i=0;i<pan;i++)
					{
						pila.pop();
					}
					if(ps==0)
					{
						pila.push("p'");
					}
					else
					{
						if(ps>0&&ps<3)
						{
							pila.push("p");
						}
						else
						
							{
								if(ps>2&&ps<6)
								{
									pila.push("Tipo");
								}
								else
								{
									if(ps>5&&ps<8)
									{
										pila.push("V");
									}
									else
									{
										if(ps==8)
										{
											pila.push("A");
										}
										else
										{
											if(ps>8&&ps<12)
											{
												pila.push("E");
											}
											else
											{
												if(ps>11&&ps<15)
												{
													pila.push("T");
												}
												else
												{
													if(ps>14&&ps<18)
													{
														pila.push("F");
													}
									
												}
											}
										}
									}
								}
							
						}
					}
					columna=0; renglon=0;
					if(pila.peek().compareTo("p'")!=0)
					{
						for(int i=0;matriz[0][i].compareTo(pila.peek())!=0;i++)
						{
							columna++;
						}
						for(int i=0;matriz[i][0].compareTo(pila.elementAt(pila.size()-2))!=0;i++)
						{
							System.out.println(matriz[i][0]);
							System.out.println(pila.elementAt(pila.size()-2));
							renglon++;
						}
						pan++;
						pila.push(matriz[renglon][columna]);
					
						for(int i=0;i<pila.size();i++)
						{
							System.out.print(pila.elementAt(i)+" ");
						}
						System.out.println();
					}
					else
					{
						Fin=false;
					}
				}
				if(Fin)
				{
					act=pila.size()-1;
					pilaS+="\n";
					for(int i=0;i<pila.size();i++)
					{
						pilaS+=pila.elementAt(i)+" ";
						//System.out.println(pila[i]);
					}
				}
				else
				{
					pilaS+="\n";
					pilaS+="$"+" ";
					pilaS+="q0"+" ";
					pilaS+="p'";
					pilaS+="\n";
					pilaS+="\n";
					pilaS+="ACEPTADA";
				}
				pilaS+="\n";
			}
			else
			{
				//en caso de que haya un salto de linea
				act2++;
				nl++;
			}
		}
		return pilaS;
	}
	public String[] getPilaerror(){
		String vec[]=new String[pilaerror.size()];
		int i,j;
		for(i=0,j=this.pilaerror.size()-1; i<=j ;i++){ //pila errores
			vec[i]=this.pilaerror.elementAt(i);
		}
		return vec;		
	}
}
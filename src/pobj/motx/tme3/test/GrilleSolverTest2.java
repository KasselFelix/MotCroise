package pobj.motx.tme3.test;



	import static org.junit.Assert.*;

	import org.junit.Test;

	import pobj.motx.tme1.Grille;
	import pobj.motx.tme1.GrilleLoader;
	import pobj.motx.tme1.GrillePlaces;
	import pobj.motx.tme2.Dictionnaire;
	import pobj.motx.tme2.GrillePotentiel;
	import pobj.motx.tme3.csp.MotX;
	import pobj.motx.tme3.csp.CSPSolver;
import pobj.motx.tme3.csp.ICSP;

	public class GrilleSolverTest2 {
		
		@Test
		public void testEasy() {
			System.out.println("============ Easy Test ============");
			Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
			Grille gr = GrilleLoader.loadGrille("data/easy.grl");
			
			System.out.println(gr);

			GrillePlaces grille = new GrillePlaces(gr);
			GrillePotentiel gp = new GrillePotentiel(grille, gut);
			
			//System.out.println(gp);
			assertTrue(! gp.isDead());

			ICSP problem = new MotX(gp);
			CSPSolver solver = new CSPSolver();

			long timestamp = System.currentTimeMillis();
			ICSP solution = solver.solve(problem);

			System.out.println("Solution \n" + solution + " \nCalculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
			System.out.println("============ END Easy Test ============");
	}
		@Test
		public void testMedium() {
			System.out.println("============ Medium Test ============");
			Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
			Grille gr = GrilleLoader.loadGrille("data/medium.grl");
			
			System.out.println(gr);

			GrillePlaces grille = new GrillePlaces(gr);
			GrillePotentiel gp = new GrillePotentiel(grille, gut);
			
			//System.out.println(gp);
			assertTrue(! gp.isDead());

			ICSP problem = new MotX(gp);
			CSPSolver solver = new CSPSolver();

			long timestamp = System.currentTimeMillis();
			ICSP solution = solver.solve(problem);

			System.out.println("Solution \n" + solution + " \nCalculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
			System.out.println("============ END Medium Test ============");	
	}
		@Test
		public void testEnonce() {
			System.out.println("============ Enonce Test ============");
			Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
			Grille gr = GrilleLoader.loadGrille("data/enonce.grl");

			System.out.println(gr);

			GrillePlaces grille = new GrillePlaces(gr);
			GrillePotentiel gp = new GrillePotentiel(grille, gut);
			
			//System.out.println(gp);
			assertTrue(! gp.isDead());

			ICSP problem = new MotX(gp);
			CSPSolver solver = new CSPSolver();

			long timestamp = System.currentTimeMillis();
			ICSP solution = solver.solve(problem);

			System.out.println("Solution \n" + solution + " \nCalculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
			System.out.println("============ END Enonce Test ============");
	}
		@Test
		public void testHard() {
			System.out.println("============ Hard Test ============");
			Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
			Grille gr = GrilleLoader.loadGrille("data/hard.grl");

			System.out.println(gr);

			GrillePlaces grille = new GrillePlaces(gr);
			GrillePotentiel gp = new GrillePotentiel(grille, gut);
			
			//System.out.println(gp);
			assertTrue(! gp.isDead());

			ICSP problem = new MotX(gp);
			CSPSolver solver = new CSPSolver();

			long timestamp = System.currentTimeMillis();
			ICSP solution = solver.solve(problem);

			System.out.println("Solution \n" + solution + " \nCalculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
			System.out.println("============ END Hard Test ============");
	}

}



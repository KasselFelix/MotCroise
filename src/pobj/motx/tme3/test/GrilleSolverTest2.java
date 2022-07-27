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
import pobj.motx.tme3.csp.StratFirst;
import pobj.motx.tme3.csp.StratMin;

	public class GrilleSolverTest2 {
		
		
		//@Test
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
			
			//solver.setChoixVarStrat(new StratFirst());
			//solver.setChoixVarStrat(new StratMin());

			long timestamp = System.currentTimeMillis();
			ICSP solution = solver.solve(problem);

			System.out.println("Solution \n" + solution + " \nCalculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
			System.out.println("============ END Enonce Test ============");
	}
		//@Test
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
			
			//solver.setChoixVarStrat(new StratFirst());
			//solver.setChoixVarStrat(new StratMin());

			long timestamp = System.currentTimeMillis();
			ICSP solution = solver.solve(problem);

			System.out.println("Solution \n" + solution + " \nCalculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
			System.out.println("============ END Hard Test ============");
	}
		//@Test
		public void testLarger() {
			System.out.println("============ Larger Test ============");
			Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
			Grille gr = GrilleLoader.loadGrille("data/large.grl");

			System.out.println(gr);

			GrillePlaces grille = new GrillePlaces(gr);
			GrillePotentiel gp = new GrillePotentiel(grille, gut);
			
			//System.out.println(gp);
			assertTrue(! gp.isDead());

			ICSP problem = new MotX(gp);
			CSPSolver solver = new CSPSolver();
			
			//solver.setChoixVarStrat(new StratFirst());
			//solver.setChoixVarStrat(new StratMin());

			long timestamp = System.currentTimeMillis();
			ICSP solution = solver.solve(problem);

			System.out.println("Solution \n" + solution + " \nCalculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
			System.out.println("============ END Larger Test ============");
	}
		//@Test
		public void testLarger2() {
			System.out.println("============ Larger2 Test ============");
			Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
			Grille gr = GrilleLoader.loadGrille("data/large2.grl");

			System.out.println(gr);

			GrillePlaces grille = new GrillePlaces(gr);
			GrillePotentiel gp = new GrillePotentiel(grille, gut);
			
			//System.out.println(gp);
			assertTrue(! gp.isDead());

			ICSP problem = new MotX(gp);
			CSPSolver solver = new CSPSolver();
			
			//solver.setChoixVarStrat(new StratFirst());
			//solver.setChoixVarStrat(new StratMin());

			long timestamp = System.currentTimeMillis();
			ICSP solution = solver.solve(problem);

			System.out.println("Solution \n" + solution + " \nCalculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
			System.out.println("============ END Larger2 Test ============");
	}

		//@Test
		public void testLarger3() {
			System.out.println("============ Larger3 Test ============");
			Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
			Grille gr = GrilleLoader.loadGrille("data/large3.grl");

			System.out.println(gr);

			GrillePlaces grille = new GrillePlaces(gr);
			GrillePotentiel gp = new GrillePotentiel(grille, gut);
			
			//System.out.println(gp);
			assertTrue(! gp.isDead());

			ICSP problem = new MotX(gp);
			CSPSolver solver = new CSPSolver();
			
			//solver.setChoixVarStrat(new StratFirst());
			//solver.setChoixVarStrat(new StratMin());

			long timestamp = System.currentTimeMillis();
			ICSP solution = solver.solve(problem);

			System.out.println("Solution \n" + solution + " \nCalculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
			System.out.println("============ END Larger3 Test ============");
	}
		
		@Test
		public void testLarger4() {
			System.out.println("============ Larger4 Test ============");
			Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
			Grille gr = GrilleLoader.loadGrille("data/large4.grl");

			System.out.println(gr);

			GrillePlaces grille = new GrillePlaces(gr);
			GrillePotentiel gp = new GrillePotentiel(grille, gut);
			
			//System.out.println(gp);
			assertTrue(! gp.isDead());

			ICSP problem = new MotX(gp);
			CSPSolver solver = new CSPSolver();
			
			//solver.setChoixVarStrat(new StratFirst());
			//solver.setChoixVarStrat(new StratMin());

			long timestamp = System.currentTimeMillis();
			ICSP solution = solver.solve(problem);

			System.out.println("Solution \n" + solution + " \nCalculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
			System.out.println("============ END Larger4 Test ============");
	}


}



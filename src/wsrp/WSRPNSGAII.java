/*
 * Boxiong Tan (Maximus Tann)
 * Title:        Single-objective GA framework
 * Description:  Single-objective GA framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * WSRPNSGAII.java - An NSGAII algorithm for WSRP
 */
package wsrp;
import ProblemDefine.ParameterSettings;
import ProblemDefine.ProblemParameterSettings;
import gaFactory.GAFactory;

import java.util.ArrayList;

import GAProcedure.NSGAII_NoCrossover;

/**
 * WSRPNSGAII
 *
 * @author Boxiong Tan (Maximus Tann)
 * @since PSO framework 1.0
 */
public class WSRPNSGAII extends NSGAII_NoCrossover{

	private GAFactory factory;
	private ParameterSettings pars;
	private ProblemParameterSettings proSet;


	/**
	 * Constructor
	 * @param pars Parameter settings
	 * @param proSet Problem settings
	 * @param factory factory is used to assemble parts
	 */
	public WSRPNSGAII(ParameterSettings pars, ProblemParameterSettings proSet, GAFactory factory){
		this.factory = factory;
		this.pars = pars;
		this.proSet = proSet;
		prepare();
	}

	/**
	 * All settings are prepared here,
	 * This is the list of all settings, please read carefully
	 * <ul>
	 * <li>maxGen: 		max number of generation </li>
	 * <li>maxVar: 		max number of variables in a particle</li>
	 * <li>popSize:		population Size</li>
	 * <li>lbound		lower bound of a variable</li>
	 * <li>ubound		upper bond of a variable</li>
	 * <li>optimization maximize (1) or minimize (0)</li>
	 * <li>popFit		population fitness</li>
	 * <li>popViolation  population violation number</li>
	 * <li>initPop		a population initialization method</li>
	 * <li>mutation		a mutation method</li>
	 * <li>crossover 	a crossover method</li>
	 * <li>selection		a selection method</li>
	 * <li>evaluate		evaluation method</li>
	 * <li>collector	data collector</li>
	 * <li>sort   		a sorting method</li>
	 * </ul>
	 */
	protected void prepare(){
		maxGen = pars.getMaxGen();
		maxVar = pars.getMaxVar();
		popSize = pars.getPopSize();
		mutationRate = pars.getMutationRate();
		crossoverRate = pars.getCrossoverRate();
		lbound = pars.getLbound();
		ubound = pars.getUbound();
		optimization = pars.getOptimization();
		tournamentSize = pars.getTournamentSize();
		elitSize = pars.getElitSize();
		popFit = new ArrayList<double[]>();

		initPop = factory.getInitPopMethod();
		mutation = factory.getMutation();
		constraint = factory.getConstraint();
		selection = factory.getSelection(tournamentSize, optimization);
		evaluate = proSet.getEvaluate();
		collector = factory.getDataCollector();
		sort = factory.getSort();
		distance = factory.getDistance();
		crossover = factory.getCrossover();
	}

}

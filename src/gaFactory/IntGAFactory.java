/*
 * Boxiong Tan (Maximus Tann)
 * Title:        PSO algorithm framework
 * Description:  PSO algorithm framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * OriginalBPSOFactory.java - A factory to assemble different parts
 */
package gaFactory;

import algorithm.Crossover;
import algorithm.InitPop;
import algorithm.Mutation;
import algorithm.Selection;
import commonOperators.*;
import dataCollector.DataCollector;
/**
 * IntGAFactory
 *
 * @author Boxiong Tan (Maximus Tann)
 * @since PSO framework 1.0
 */
public class IntGAFactory implements GAFactory{
	private DataCollector collector;

	/**
	 * Constructor
	 * @param collector is the data collector
	 */
	public IntGAFactory(DataCollector collector){
		this.collector = collector;
	}

	@Override
	public InitPop getInitPopMethod() {
		return new InitIntChromosomes();
	}


	@Override
	public DataCollector getDataCollector() {
		return collector;
	}

	@Override
	public Mutation getMutation() {
		return  new IntReverseSequenceMutation();
	}
	

	@Override
	public Selection getSelection() {
		return null;
	}

	@Override
	public Crossover getCrossover() {
		return new SinglePointCrossover();
	}



}
/*
 * Boxiong Tan (Maximus Tann)
 * Title:        Single-objective GA framework
 * Description:  Single-objective GA framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * Mutation.java - an interface of mutation operator, please implement this interface.
 */
package algorithms;

/**
 * An interface of mutation operator
 * 
 * @author Boxiong Tan (Maximus Tann) 
 * @since GA framework 1.0
 */
public interface Mutation {
    /**
     * 
     * @param individual a piece of chromosome
     * @param mutationRate the probability of mutation
     */	
	public void update(
			Chromosome individual,
			double mutationRate 
			);
	
}

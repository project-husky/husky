/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/
package org.ehealth_connector.communication;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The Class AffinityDomain represents the configuration of an IHE Affinity
 * Domain.
 */
public class AffinityDomain {

	/** The atna config. */
	private AtnaConfig atnaConfig;

	/** The patient identification oid within this affinity Domain. */
	private String mpiPid;

	/** The repositories Destination. */
	private List<Destination> mRepositories;

	/** Identities like SSN. */
	private Set<String> otherIdsOidSet;

	/** The destination to for the pdq of the mpi. */
	private Destination pdqDestination = null;

	/** The destination to the pix Source of the mpi. */
	private Destination pixDestination = null;

	/** The destination to the registry. */
	private Destination registryDestination = null;

	/**
	 * Instantiates a new affinity domain.
	 */
	public AffinityDomain() {
		mRepositories = new ArrayList<Destination>();
		otherIdsOidSet = new HashSet<String>();
	}

	/**
	 * Instantiates a new affinity domain.
	 * 
	 * @param destPidSource
	 *            the dest pid source
	 * @param destRegistry
	 *            the dest registry
	 * @param destRepository
	 *            the dest repository
	 */
	public AffinityDomain(Destination destPidSource, Destination destRegistry,
			Destination destRepository) {
		pixDestination = destPidSource;
		registryDestination = destRegistry;
		mRepositories = new ArrayList<Destination>();
		mRepositories.add(destRepository);
		otherIdsOidSet = new HashSet<String>();
	}

	/**
	 * Instantiates a new affinity domain.
	 * 
	 * @param destPidSource
	 *            the dest pid source
	 * @param destRegistry
	 *            the dest registry
	 * @param destRepositories
	 *            the dest repositories
	 */
	public AffinityDomain(Destination destPidSource, Destination destRegistry,
			List<Destination> destRepositories) {
		pixDestination = destPidSource;
		registryDestination = destRegistry;
		mRepositories = destRepositories;
		otherIdsOidSet = new HashSet<String>();
	}

	/**
	 * Adds an other Identificator (like a SSN) ot the affinity Domain.
	 * 
	 * @param oid
	 *            the oid
	 */
	public void addOtherId(String oid) {
		otherIdsOidSet.add(oid);
	}

	/**
	 * Adds the repository.
	 * 
	 * @param destRepository
	 *            the dest repository
	 */
	public void addRepository(Destination destRepository) {
		mRepositories.add(destRepository);
	}

	/**
	 * Clear repositories.
	 */
	public void clearRepositories() {
		mRepositories = new ArrayList<Destination>();
	}

	/**
	 * Gets the atna config.
	 * 
	 * @return the atna config
	 */
	public AtnaConfig getAtnaConfig() {
		return atnaConfig;
	}

	/**
	 * Gets the mpi pid.
	 * 
	 * @return the mpi pid
	 */
	public String getMpiPid() {
		return mpiPid;
	}

	/**
	 * Gets the other ids oid set.
	 * 
	 * @return the other ids oid set
	 */
	public Set<String> getOtherIdsOidSet() {
		return otherIdsOidSet;
	}

	/**
	 * Gets the pdq destination.
	 * 
	 * @return the pdq destination
	 */
	public Destination getPdqDestination() {
		return pdqDestination;
	}

	/**
	 * Gets the pid source.
	 * 
	 * @return the pid source
	 */
	public Destination getPixDestination() {
		return pixDestination;
	}

	/**
	 * Gets the registry.
	 * 
	 * @return the registry
	 */
	public Destination getRegistryDestination() {
		return registryDestination;
	}

	/**
	 * Gets the repository.
	 * 
	 * @return the repository
	 */
	public Destination getRepositoryDestination() {
		Destination retVal = null;
		if (!mRepositories.isEmpty()) {
			retVal = mRepositories.get(0);
		}
		return retVal;
	}

	/**
	 * Gets the repository.
	 * 
	 * @param index
	 *            the index
	 * @return the repository
	 */
	public Destination getRepositoryDestination(int index) {
		Destination retVal = null;
		if (!mRepositories.isEmpty()) {
			retVal = mRepositories.get(index);
		}
		return retVal;
	}

	/**
	 * Sets the atna config.
	 * 
	 * @param atnaConfig
	 *            the new atna config
	 */
	public void setAtnaConfig(AtnaConfig atnaConfig) {
		this.atnaConfig = atnaConfig;
	}

	/**
	 * Sets the mpi pid.
	 * 
	 * @param mpiPid
	 *            the new mpi pid
	 */
	public void setMpiPid(String mpiPid) {
		this.mpiPid = mpiPid;
	}

	/**
	 * Sets the other ids oid set.
	 * 
	 * @param otherIdsOidSet
	 *            the new other ids oid set
	 */
	public void setOtherIdsOidSet(Set<String> otherIdsOidSet) {
		this.otherIdsOidSet = otherIdsOidSet;
	}

	/**
	 * Sets the pdq destination.
	 * 
	 * @param pdqDestination
	 *            the new pdq destination
	 */
	public void setPdqDestination(Destination pdqDestination) {
		this.pdqDestination = pdqDestination;
	}

	/**
	 * Sets the pix source.
	 * 
	 * @param destPidSource
	 *            the new pid source
	 */
	public void setPixDestination(Destination destPidSource) {
		pixDestination = destPidSource;
	}

	/**
	 * Sets the registry.
	 * 
	 * @param destRegistry
	 *            the new registry
	 */
	public void setRegistryDestination(Destination destRegistry) {
		registryDestination = destRegistry;
	}

	/**
	 * Sets the repository.
	 * 
	 * @param destRepository
	 *            the new repository
	 */
	public void setRepositoryDestination(Destination destRepository) {
		mRepositories = new ArrayList<Destination>();
		mRepositories.add(destRepository);
	}

}

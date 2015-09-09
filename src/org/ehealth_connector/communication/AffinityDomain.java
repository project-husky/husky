package org.ehealth_connector.communication;

import java.util.ArrayList;
import java.util.List;

public class AffinityDomain {

	private Destination mPidSource = null;
	private Destination mRegistry = null;
	private List<Destination> mRepositories = new ArrayList<Destination>();

	public AffinityDomain(Destination destPidSource, Destination destRegistry,
			Destination destRepository) {
		mPidSource = destPidSource;
		mRegistry = destRegistry;
		mRepositories = new ArrayList<Destination>();
		mRepositories.add(destRepository);
	}

	public AffinityDomain(Destination destPidSource, Destination destRegistry,
			List<Destination> destRepositories) {
		mPidSource = destPidSource;
		mRegistry = destRegistry;
		mRepositories = destRepositories;
	}

	public Destination getPidSource() {
		return mPidSource;
	}

	public void setPidSource(Destination destPidSource) {
		mPidSource = destPidSource;
	}

	public Destination getRegistry() {
		return mRegistry;
	}

	public void setRegistry(Destination destRegistry) {
		mRegistry = destRegistry;
	}

	public Destination getRepository() {
		Destination retVal = null;
		if (!mRepositories.isEmpty()) {
			retVal = mRepositories.get(0);
		}
		return retVal;
	}

	public Destination getRepository(int index) {
		Destination retVal = null;
		if (!mRepositories.isEmpty()) {
			retVal = mRepositories.get(index);
		}
		return retVal;
	}

	public void clearRepositories() {
		mRepositories = new ArrayList<Destination>();
	}

	public void addRepository(Destination destRepository) {
		mRepositories.add(destRepository);
	}

	public void setRepository(Destination destRepository) {
		mRepositories = new ArrayList<Destination>();
		mRepositories.add(destRepository);
	}

}

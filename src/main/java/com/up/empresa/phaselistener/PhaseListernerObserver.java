package com.up.empresa.phaselistener;

import java.lang.annotation.Annotation;

import javax.enterprise.inject.Vetoed;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;
import javax.enterprise.util.AnnotationLiteral;
import javax.faces.event.PhaseEvent;

import com.up.empresa.phaselistener.annotation.After;
import com.up.empresa.phaselistener.annotation.Before;
import com.up.empresa.phaselistener.annotation.PhaseLiteral;

@SuppressWarnings("serial")
@Vetoed
public class PhaseListernerObserver {

	private BeanManager observer = CDI.current().getBeanManager();
	private Annotation momento;
	
	
	public PhaseListernerObserver after(){
		this.momento = new AnnotationLiteral<After>(){};
		return this;
	}
	
	
	public PhaseListernerObserver before(){
		this.momento = new AnnotationLiteral<Before>(){};
		return this;
	}
	
	public void fire(PhaseEvent phaseEvent){
		observer.fireEvent(phaseEvent, momento,new PhaseLiteral(phaseEvent.getPhaseId()) );
	}
	
}

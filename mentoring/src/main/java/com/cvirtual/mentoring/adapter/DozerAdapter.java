package com.cvirtual.mentoring.adapter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class DozerAdapter {

	private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	
	public static <O,D> D parseObject(O origin, Class<D> destination) {
		return mapper.map(origin, destination);
	}
	
	public static <O,D> List<D> parseListObjects(List<O> origin, Class<D> destination) {
		List<D> destnationObjects = new ArrayList<D>();
		for (Object o : origin) {
			destnationObjects.add(mapper.map(o, destination));
		}
		return destnationObjects;
	}
	
	public static <O,D> List<D> parseListObjects(Page<O> origin, Class<D> destination) {
		List<D> destnationObjects = new ArrayList<D>();
		for (Object o : origin) {
			destnationObjects.add(mapper.map(o, destination));
		}
		return destnationObjects;
	}
}


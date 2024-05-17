package com.example.one.serviceimpl;

import com.example.one.model.entity.Element;
import com.example.one.model.response.Atom;
import com.example.one.repository.ElementRepository;
import com.example.one.service.Interact;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InteractImpl implements Interact {
    private final ElementRepository elementRepository;

    @Override
    public List<Atom> getAll() {
        List<Element> list = elementRepository.findAll();
        return list.stream().map(element -> Atom.builder()
                .name(element.getFullname())
                .abbr(element.getAbbr())
                .photon(element.getPhoton())
                .neutron(element.getNeutron())
                .mass(element.getMass())
                .meltingPoint(element.getMp())
                .boilingPoint(element.getBp())
                .build())
                .toList();
    }

    @Override
    public Element get() {
        return new Element();
    }

    @Override
    public Element add(Element element) {
        return new Element();
    }

    @Override
    public void distract() {

    }
}

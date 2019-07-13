package com.escalade.data.util;

import com.escalade.data.model.Topo;
import com.escalade.svc.contracts.FilesService;
import com.escalade.svc.contracts.TopoService;

import java.util.ArrayList;

public class DefineAttributes {

    public Iterable<Integer> defineDownload(TopoService topoService, FilesService filesService) {

        Iterable<Integer> h = new ArrayList<Integer>();
        Iterable<Topo> topos = topoService.getAllTopo();
        for (Topo topo : topos) {

            if (filesService.existsAllByTopoId(topo.getTopoId())) {
                ((ArrayList<Integer>) h).add(topo.getTopoId());
            }
        }

        return h;
    }
}

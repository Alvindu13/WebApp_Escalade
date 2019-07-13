package com.escalade.svc.contracts;

import com.escalade.data.model.Sector;

public interface SectorService {

    void createSector(Sector s);
    long getCountSector(int siteId);
    Iterable<Sector> listSector(int siteId);

}

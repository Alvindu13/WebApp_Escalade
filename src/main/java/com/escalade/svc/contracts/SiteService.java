package com.escalade.svc.contracts;

import com.escalade.data.model.Site;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface SiteService {

    void createSite(Site s);
    Page<Site> getAllByTopoId(int topoId, Pageable pageable);
    Site getSiteBySiteId(int siteId);
    List<Site> getAllSiteByResearch(String location, String cotationMini, String cotationMaxi);
    Iterable<String> getDisctinctLocation();
    Page<Site> getAllSiteByCritera(String mc, Pageable pageable);

}

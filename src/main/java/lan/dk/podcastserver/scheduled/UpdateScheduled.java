package lan.dk.podcastserver.scheduled;

import lan.dk.podcastserver.business.UpdatePodcastBusiness;
import lan.dk.podcastserver.manager.ItemDownloadManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by kevin on 26/12/2013.
 */
@Component
public class UpdateScheduled {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private @Resource UpdatePodcastBusiness updatePodcastBusiness;
    private @Resource ItemDownloadManager IDM;

    @Scheduled(cron="${podcastserver.updateAndDownload.refresh.cron:0 0 * * * *}")
    //@Scheduled(fixedRate = 3600000)
    /*@Scheduled(cron="0 0 * * * *")*/
    private void updateAndDownloadPodcast() {
        logger.info(">>> Beginning of the update <<<");
        updatePodcastBusiness.updateAsyncPodcast();
        IDM.launchDownload();
        logger.info(">>> End of the update <<<");
    }
}

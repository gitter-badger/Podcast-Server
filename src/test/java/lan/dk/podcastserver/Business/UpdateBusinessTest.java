package lan.dk.podcastserver.Business;

import lan.dk.podcastserver.business.ItemBusiness;
import lan.dk.podcastserver.config.BeanConfigScan;
import lan.dk.podcastserver.entity.Podcast;
import lan.dk.podcastserver.repository.PodcastRepository;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.annotation.Resource;

/**
 * Created by kevin on 01/02/2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {/*PropertyConfig.class,*/ /*HibernateSearchConfig.class,*/ BeanConfigScan.class}, loader=AnnotationConfigContextLoader.class)
@ActiveProfiles("data-embedded")
public class UpdateBusinessTest {

    @Resource PodcastRepository podcastRepository;
    @Resource ItemBusiness itemBusiness;

    Podcast podcastToBeDeleted;
    Podcast podcastToBeKept;
/*
    @Before
    public void before() {
        itemBusiness.deleteAll();

        podcastToBeDeleted = new Podcast("Le Rendez-vous Tech", "http://feeds.feedburner.com/lerendezvoustech", null, "RSS", null, null, null, "Description", true);
        podcastToBeKept = new Podcast("Appload", "http://feeds.feedburner.com/appload", null, "RSS", null, null, null, "Description", false);

        podcastRepository.save(podcastToBeDeleted);
        podcastRepository.save(podcastToBeKept);
    }

    @Test
    public void checkHasToBeDeleted() {

        Calendar thatWas40daysAgo = new GregorianCalendar();
        thatWas40daysAgo.setTime(new Date());
        thatWas40daysAgo.add(Calendar.DAY_OF_MONTH, -40);

        Item item = new Item()
                .setPodcast(podcastToBeDeleted)
                .setTitle("ToBeDeleted")
                .setDownloaddate(new Timestamp(thatWas40daysAgo.getTime().getTime()))
                .setStatus("Finish");

        podcastToBeDeleted.getItems().add(item);
        podcastRepository.save(podcastToBeDeleted);

        List<Item> hasToBeDeleted = itemBusiness.findAllToDelete();
        assertThat(hasToBeDeleted).hasSize(1);
    }

    @Test
    public void checkHasToBeKept() {

        Calendar thatWas40daysAgo = new GregorianCalendar();
        thatWas40daysAgo.setTime(new Date());
        thatWas40daysAgo.add(Calendar.DAY_OF_MONTH, -40);

        Item item = new Item()
                .setPodcast(podcastToBeKept)
                .setTitle("ToBeDeleted")
                .setDownloaddate(new Timestamp(thatWas40daysAgo.getTime().getTime()))
                .setStatus("Finish");

        podcastToBeDeleted.getItems().add(item);
        podcastRepository.save(podcastToBeKept);

        List<Item> hasToBeDeleted = itemBusiness.findAllToDelete();
        assertThat(hasToBeDeleted).hasSize(0);
    }*/

}

(ns stdio.front
  (:require [soda-ash.element :as s]
            [stdio.shell :refer [shell loren footnote]]))

(def navload #(stdio.nav.navload %))

(defn law-page []
  [shell "Lawyer"
   [:div
    [:p "I'm a former civil rights and legal aid lawyer with four years of litigation experience at "
     [:a {:href "http://oregonlawcenter.org"} "Oregon Law Center"]
     " and "
     [:a {:href "http://www.robinhoodesq.com"} "Victor M. Glasberg and Associates. "]

     "In those contexts, I represented victims of police misconduct (once winning a "
     [:a {:href "http://caselaw.findlaw.com/summary/opinion/us-4th-circuit/2005/06/23/130929.html"} "rare qualified immunity reversal from the Fourth Circuit"]
     "), predatory lending, employment discrimination, unlawful eviction, domestic violence, and numerous other injustices. I've been admitted to the bars of Louisiana, Massachusetts, Oregon, and Virginia, though I'm not on active status with any of them."]
    [:p "I'm also a legal scholar with many published papers in constitutional law and legal theory.  I currently serve as an associate professor of law at the "
     [:a {:href "http://law.uiowa.edu/paul-gowder"} "University of Iowa"]
     " , where I teach or have taught first-year and advanced Constitutional law, professional ethics, torts, and a policy lab seminar focused on the design of access to justice policy and technological disruption in the legal profession."]
    [:p "My legal advocacy and scholarship is inseparable from advocacy for social justice and racial, economic, and gender equality."]]])

(defn research-page []
  [shell "Researcher"
   [:div
    [:p "I'm currently an academic researcher, and in that capacity, since 2012, I've published one book, "
     [:a {:href "http://rulelaw.net"} "The Rule of Law in the Real World"]
     ", and over a dozen articles in constitutional law, political and legal philosophy, critical race theory, classical Athenian law and political theory, and distributive justice. I've also given about 40 scholarly presentations in the last 4 years. For details, see "
     [:a {:href "http://paul-gowder.com"} "my academic website"] ", where you can also download copies of many articles. Other than the book, I'm perhaps proudest of "
     [:a {:href "https://zenodo.org/record/57249"} "an article"]
     " on urban racial segregation, cognitive bias, and ascriptive injuries."]
    [:p "Currently, I'm working on more quantitative and computational projects, including some experiments with machine-learning predictions of judicial outcomes and with human-computer facilitated empirical data collection."]
    [:p "I have a Ph.D. in political science from "
     [:a {:href "https://politicalscience.stanford.edu"} "Stanford"]
     " and a law degree from "
     [:a {:href "http://hls.harvard.edu"} "Harvard."]
     " (I have also benefited from an intensive "
     [:a {:href "https://www.ucc.ie/en/classics/summerschool/"} "Attic Greek immersion course"]
     " at University College Cork, Ireland, and a number of MOOCs on things like R, Python, and Spark.)  I've been a Member at the "
     [:a {:href "https://www.sss.ias.edu"} "Institute for Advanced Study's School of Social Science"] " (2014-5), and was offered (but turned down) a fellowship at Princeton's "
      [:a {:href "http://lapa.princeton.edu"} "Law and Public Affairs"]
      " program."]]])

(defn data-page []
  [shell "Data and Code Aficionado"
   [:div
    [:p "Lately, I've been doing a lot of statistical and computational work."
     [footnote :data "Why 'aficionado'? " "I stole the general concept from a friend who started calling herself a 'data enthusiast' when 'data scientist' started to sound a little too arrogant.  But I might have accidentally arroganted it right back up with the Spanish.  Whoops."]]
    [:p "Recent data projects include the data analysis in "
     [:a {:href "http://rulelaw.net"} "The Rule of Law in the Real World"]
     ", and a nascent project to predict lawyer discipline punishments using a new dataset of 7000 cases (and counting)."]
    [:p "Recent code projects include beginning to create a Clojure "
     [:a {:href "https://github.com/paultopia/tzara"} "text-mining utility library"]
     ", a Chrome extension and Clojure backend to facilitate simultaneous human entering and computer scraping of web data (currently confidential, will be released when project is complete), and a Python "
     [:a {:href "https://github.com/paultopia/spideyscrape"} "html-book scraper"]
     "."]
    [:p "My languages of choice include Clojure for general programming, with Clojurescript for the web; Python with sklearn and the Jupyter notebook for machine learning; R for general statistics; and JavaScript when I have no other options. For visualization I use ggplot, Bokeh, and Plotly; the latter is responsible for the fancy visuals on "
     [:a {:href "http://rulelaw.net"} "the website for my book"]
     ".  I've just converted editors from Sublime Text to Emacs (with evil-mode and Spacemacs handling the config). I've been trying to find an excuse to use Spark."]
    [:p  "I'm statistically trained thanks to the Stanford polisci department's Ph.D. program, but most of my coding is self-taught---when I need something built, I learn what I need to build it myself. (I've also been a member of "
     [:a {:href "https://www.recurse.com/blog/99-free-one-on-one-mentorship-for-new-programmers"} "RC Start"]
     ".)"]
    [:p " This website is built as a pure single-page Clojurescript 'app' with Reagent (a cljs wrapper for React) and Semantic UI. The code for this site is "
     [:a {:href "https://github.com/paultopia/stdio"} "here"]
     ", and while you're there, you can check out the rest of " [:a {:href "https://github.com/paultopia/"} "my Github."]]]])

(defn media-list []
  [s/s-list {}
   [:a.item {:href "https://www.youtube.com/watch?v=ZMseruOklAA"} "TV Appearance, Free Enterprise and Religious Belief, Ethical Perspectives on the News."]
   [:a.item {:href "http://www.desmoinesregister.com/story/opinion/columnists/iowa-view/2014/07/08/supreme-court-contraceptive-ruling/12325985/"} "Op-Ed, Court Moves Toward Death for Contraceptive Coverage, Des Moines Register."]
   [:a.item {:href "http://thegazette.com/2012/10/27/independent-judiciary/"} "Op-Ed with Nick Johnson, Independent Judiciary, The Gazette."]
   [:a.item {:href "https://medium.com/@PaulGowder/ssrn-has-been-captured-by-the-enemy-of-open-knowledge-b3e5bca6751d#.ls7qe3uqc"} "Medium Post, SSRN has been captured by the enemy of open knowledge."]
   [:a.item {:href "https://medium.com/@PaulGowder/affirmative-consent-better-known-as-consent-78d9874a91ae#.22d1cpppd"} "Medium Post, 'Affirmative Consent.' Better Known as 'Consent.'"]
   [:a.item {:href "http://www.desmoinesregister.com/story/news/politics/2016/07/05/church-sues-state-iowa-over-transgender-bathroom-rules/86700392/"} "Quoted, Churches Challenge State on Gender Identity Law, Des Moines Register."]
   [:a.item {:href "http://prawfsblawg.blogs.com/prawfsblawg/2016/02/i-for-one-welcome-our-new-robot-law-lords.html"} "Blog Post, I, for One, Welcome our new Robot Law Lords, Prawfsblawg."]
   [:a.item {:href "http://prawfsblawg.blogs.com/prawfsblawg/2015/01/the-problem-with-petty-pedantic-penny-ante-policing.html"} "Blog Post, The Problem With Petty, Pedantic, Penny-Ante Policing, Prawfsblawg."]])

(defn comm-page []
  [shell "Communicator"
   [:div
    [:p "I'm a very experienced public speaker and writer. On the writing side, in addition to my dozen+ academic articles, book chapters, book, and the like, I also regularly write blog posts, semi-viral Medium articles, and the occasional op-ed."]
    [:p "I also have a bit of a media presence. In particular, I'm routinely quoted (and occasionally misquoted) on questions of constitutional law, including religious liberty and free speech."]
    [:p "Speaking-wise, I have given almost 50 academic talks and a number of public presentations, mostly in the last four years; I have appeared before innumerable courts; and I have (depending on how you count) anything between 4 and 8 years of teaching experience, teaching University of Iowa law students, Stanford undergraduates, and highly gifted high school students."]
    [:p "Some representative posts and media appearances include: "]
    [media-list]]])

(defn innovation-page []
  [shell "Innovation Activist"
   [:div
    [:p "I'm actively working to promote innovations in open knowledge and scholarship as well as in disruptive legal technology."]
    [:p "I have become active in the open access movement, primarily as an "
     [:a {:href "https://medium.com/@PaulGowder/ssrn-has-been-captured-by-the-enemy-of-open-knowledge-b3e5bca6751d#.wem4mv7ma"} "advocate"]
     ", but also working with several organizations and independent developers to promote and develop open-access repositories and other noncommercial scholarly tools. I recently spent a week embedded in a JSTOR labs design sprint as a consultant to help them develop innovative research applications. Many of my efforts in this area are semi-confidential, at least until the various services that I'm involved with either fizzle out or become public, but I'm happy to discuss them on a cautious and individual basis."]
    [:p "I first entered the legal technology space in developing an "
     [:a {:href "http://paul-gowder.com/policylab/"} "experimental class"]
     " for the entire 2014-5 academic year, called the Policy Lab, in which I gathered a group of law students and guest speakers from industry and the academy to examine the impact of internet-mediated cross-jurisdictional practice, machine learning, computational contracts, and other disruptive legal technologies, on access to justice. I am now beginning to write in the area, and have committed to write and present a full-fledged manifesto on the role of legal technology in enhancing access to justice in Spring of 2017."]]])

(defn front-navitem
  [icon content nom]
  [:div.item
   [s/icon {:soda {:icon icon :color :black} :on-click #(navload nom)}]
   [:div.content {:style {:color "black"} :on-click #(navload nom)} content]])

(defn front-menu []
  [:div
   [s/s-list {:soda {:selection? true :size :large}}
    [front-navitem :legal "Law" :law]
    [front-navitem :book "Research and Knowledge" :research]
    [front-navitem :line-chart "Data and Code" :data]
    [front-navitem :write "Communication" :communication]
    [front-navitem :lightning "Innovation and Policy Leadership" :innovation]]])

(defn home-page []
  [shell "Welcome!"
   [:div
    [:p "I'm a lawyer, researcher, data and code aficionado, and policy and innovation advocate. This website exists to provide a concise presentation of the different things I do and have done."]

[:p "You can grab a one-page resume "
     [:a {:href "http://gowder.io/resume.pdf"} "here" ]
 ", and see a lengthy "
 [:a {:href "http://paul-gowder.com/cv.html"} "academic c.v."]
 ", with publications, courses, etc. and a picture of my cat on "
 [:a {:href "http://paul-gowder.com"} "paul-gowder.com"]". I also have a "
 [:a {:href "https://www.linkedin.com/in/paulgowder"} "LinkedIn"] " and a "
 [:a {:href "https://github.com/paultopia"} "Github"] ". To contact me, just send an e-mail to pgowder [at] post.harvard.edu."]
    [:p "Just in case the minimalistic navigation is too obscure, you can click the footnote to learn how to get around."
     [footnote :home "Navigation instructions" ": The menu below describes the pages of this site, which are also navigable using the top buttons, or via keyboard. To use the keyboard, press the first letter of any top-level page (H for home, L for law, R for research, etc.). To open a footnote, type its number or click. To get out of here, click anywhere or press any key. (And yes, I know this is a little gratuitous. I'm thinking of adding voice commands too just for fun.)"]]
    [front-menu]]])

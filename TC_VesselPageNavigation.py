# Library imports
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.common.keys import Keys

# Our imports
from Login import Login, Logout
from Nav import Nav, navToSublink
from constants import constPaths # paths that should never change



    
# from builtins import True


# ---------------------------- #
# Settings - Change as needed #
# --------------------------- #
useBrowser = 'chrome' #edge, chrome
maxWindowOnLoad = True
closeBrowserWhenFinished = False
defaultWaitTime = 10 # seconds - time default wait before select fails
useEnv = 'portaluat'
env = {
  'fredmod'   :  'https://fredmod.eagle.org/portal/#/Login',
  'fredint'   :  'https://fredint.eagle.org/portal/#/Login',
  'portaluat' :  'https://portaluat.eagle.org/portal//#/Login'
}

# --------------------------------- #
# Settings - Change if you have to  #
# --------------------------------- #
if useBrowser == 'edge':
#     Add webdrivers as needed (edge / chrome / firefox)
    browser = webdriver.Edge('msedgedriver')
else:
    browser = webdriver.Chrome()
browser.get(env[useEnv])

if maxWindowOnLoad == True:
    browser.set_window_size(1440, 900)
    browser.maximize_window()

# time to try to find NEXT element before timeout
# should be used to you just need for next item to exist before you continue
def pause(time = defaultWaitTime):
    browser.implicitly_wait(time)
# force browser to pause before moving on
# should be used to you need to see what is happening
def fPause(time = defaultWaitTime):
    browser.implicitly_wait(time)
    cantGetItem = browser.find_elements_by_css_selector('.will-never-find-this-item')

# /\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\ #
# ------------------------------------------------------------------ #
# ===================== Tests / Commands below ===================== #
# ------------------------------------------------------------------ #
# \/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/ #

def navigate(driver, toPage):
    navButtons = driver.find_elements_by_class_name('nav-item')
    index = 0
    if toPage == "Fleet Overview":
        index = 1
    if toPage == "Finance":
        index = 3
    if toPage == "Company_Dashboard":
        index = 2
    navButtons[index].click()
    print(len(navButtons))
    
runTest = False
if runTest:
    Login(browser, pause, 'MTM', 'abc12345')
    Nav(browser, By, pause, "Home")
    fPause()
    Nav(browser, By, pause, "Fleet Overview")
    fPause()
    cardList = browser.find_elements_by_css_selector('.vessel-cards-list .row div')
    cardList[0].click() #click first card
    pause()
    navToSublink(browser, pause, By, 'Vessel', 'Vessel Overview')
    fPause()
    navToSublink(browser, pause, By, 'Vessel','Vessel Details')
    fPause()
    navToSublink(browser, pause, By, 'Vessel','Owner')
    fPause()
    navToSublink(browser, pause, By, 'Vessel','Vessel Assets')
    fPause()
    navToSublink(browser, pause, By, 'Vessel','Parts')
    fPause()
    navToSublink(browser, pause, By, 'Vessel','Condition')
    fPause()
    navToSublink(browser, pause, By, 'Vessel','Surveys')
    fPause()
    navToSublink(browser, pause, By, 'Vessel','Findings')
    fPause()
    navToSublink(browser, pause, By, 'Vessel','Certificates')
    fPause()
    navToSublink(browser, pause, By, 'Vessel','Alerts Archive')
    fPause()
    navToSublink(browser, pause, By, 'Vessel','Place Order')
    fPause()
    navToSublink(browser, pause, By, 'Vessel','Orders')
    fPause()
    navToSublink(browser, pause, By, 'Vessel','Timeline')
    fPause()
    Logout(browser, pause)
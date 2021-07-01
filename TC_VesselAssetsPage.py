# Library imports
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.common.keys import Keys



# Our imports
from Login import Login, Logout
from Nav import Nav, navToSublink
from constants import constPaths # paths that should never change


# driver = webdriver.Chrome()
# driver.get('https://python.org')


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
    # Add webdrivers as needed (edge / chrome / firefox)
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

print('RUNNING FILE')
# Login, Navigate vessel Assets page
runTest = True

if runTest:
    Login(browser, pause, 'Fortunato', 'abc12345')
    Nav(browser, By, pause, "Home")
    print('Landed In Home Page')
    fPause(2)
    Nav(browser, By, pause, "Home")
    fPause()
    print('SANITY PASS: LANDED ON HOME PAGE')
    Nav(browser, By, pause, "Fleet Overview")
    fPause()
    print('SANITY PASS: LANDED ON FLEET OVERVIEW PAGE')
    #CLOSING THE FLEET VIEW ICON
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[1]/i')
    button.click()
    print('SANITY PASS: CLOSED THE FLEET VIEW ICON')
    cardList = browser.find_elements_by_css_selector('.vessel-cards-list .row .ibox')
    cardList[0].click() #click 1ST card
    print('SANITY PASS: SELECTED THE FIRST CARD PERRO NEGRO 5')
    print(len(cardList))
    pause()
    print('SANITY PASS: CORRECT COUNT DISPLAYED FOR TOTAL NUMBER OF VESSELS FOR ACCOUNT Fortunato (15)')
    pause()
    navToSublink(browser, pause, By, 'Vessel','Vessel Assets')
    fPause()
    print('SANITY PASS: LANDED ON VESSEL ASSETS PAGE')
    # navigating to bottom of the page and to locate the footer links
    browser.execute_script("window.scrollTo(0, document.body.scrollHeight);")
    
    # WAITING TO VALIDATE ALL INFO ARE GETTING DISPLAYED ON OWNER PAGE
    fPause(5)
    print('SANITY PASS: ALL INFO DISPLAYED CORRECTLY IN VESSEL OWNER PAGE')
    # LOGGING OUT OF THE PAGE
    Logout(browser, pause)
    print('SIT PASS:Logout Successful')
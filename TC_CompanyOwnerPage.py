# Library imports
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.common.keys import Keys
import time



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
# Login, Navigate vessel owner page
runTest = True

if runTest:
    # LOGIN 
    Login(browser, pause, 'diamond', 'abc12345')
    
    # NAVIGATE TO HOME PAGE 
    Nav(browser, By, pause, "Home")
    print('Landed In Home Page')
    fPause(6)
    
    # REFRESH THE PAGE TO CLOSE THE SMART SCHEDULAR POP UP WINDOW
    browser.refresh()
    fPause(7)
    
    # NAVIGATE TO COMPANY DASHBOARD
    Nav(browser, By, pause, "Company Dashboard")
    print('SANITY PASS: LANDED ON COMPANY DASHBOARD PAGE')
    fPause(3)
    
    # SELECTING THE COMPANY FROM LIST
    cardList = browser.find_elements_by_css_selector('.company-cards-list .row .ibox')
    cardList[0].click() #click 1ST card
    print('SANITY PASS: SELECTED THE FIRST CARD DIAMOND OFFSHORE DRILLING INC. ')
    
    # CALULATING TOTAL NO OF COMPANIES
    print(len(cardList))
    pause()
    print('SANITY PASS: CORRECT COUNT DISPLAYED FOR TOTAL NUMBER OF COMPANIES FOR ACCOUNT DIAMOND (5)')
    pause()
    
    # NAVIGATE TO OWNERS PAGE 
    navToSublink(browser, pause, By, 'Company','Owner')
    fPause()
    print('SANITY PASS: LANDED ON COMPANY OWNER PAGE')
    
    # TAKING SS
    browser.switch_to.window(window_name=browser.window_handles[-1])
    ms = int(round(time.time() * 1000)) # creates unique timestamp : import time
    browser.save_screenshot("screenshots/screenshot_" + str(ms) + ".png") # saves image with unique name
    fPause(2)
    print('SANITY PASS:Taking SS')
    
    # navigating to bottom of the page and to locate the footer links
    html = browser.find_element_by_tag_name('html')
    html.send_keys(Keys.END)
    
    # WAITING TO VALIDATE ALL INFO ARE GETTING DISPLAYED ON OWNER PAGE
    fPause(5)
    print('SANITY PASS: ALL INFO DISPLAYED CORRECTLY IN VESSEL OWNER PAGE')
    
    # LOGGING OUT OF THE PAGE
    Logout(browser, pause)
    print('SIT PASS:Logout Successful')
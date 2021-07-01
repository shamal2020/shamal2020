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


#Test Scripts for Login, go to home, fleet overview, select vessel, vessel overview and click on View all links:
runTest = True
if runTest:
    #Trying to login to the page
    Login(browser, pause, 'MTM', 'abc12345')
    print('SANITY PASS:Log in Successful')
    fPause(1)
    
    #Navigating to Home page
    Nav(browser, By, pause, "Home")
    print('SANITY PASS:Landed in Home page Successful')
    fPause(5)
    
    # Refresh the page to close the smart schedular pop up
    browser.refresh()
    
    # Navigating to load Fleet Overview page.
    Nav(browser, By, pause, "Fleet Overview")
    print('SANITY PASS:Fleet Overview landing page Successful')
    fPause(3)
    
    # Displaying the total no of cards and Selecting the first card from the list
    cardList = browser.find_elements_by_css_selector('.vessel-cards-list .row .ibox')
    print(len(cardList))
    cardList[0].click()
    print('SANITY PASS:Card Selected From Fleet Overview page')
    
    # Navigating to Vessel Overview Page.
    navToSublink(browser, pause, By, 'Vessel', 'Vessel Overview')
    print('SANITY PASS:Vessel Overview landing page Successful')
    fPause(2)
    
    #TAKING SS
    browser.switch_to.window(window_name=browser.window_handles[-1])
    ms = int(round(time.time() * 1000)) # creates unique timestamp : import time
    browser.save_screenshot("screenshots/screenshot_" + str(ms) + ".png") # saves image with unique name
    fPause(2)
    print('SANITY PASS:Taking SS')

    
    # Navigating to View All Links of Surveys on Vessel Overview Page 
    Paneltitle = browser.find_element_by_xpath('//main/div/div[2]/div[2]/div[2]/div[1]/div/div/div[1]/div/div[1]/a')
    Paneltitle.click()
    print('SANITY PASS:Clicking on View All Links on Surveys')
    
    # Waiting for the page to load
    fPause(2)
    
    # Navigating Back to Vessel overview Page
    navToSublink(browser, pause, By, 'Vessel', 'Vessel Overview')
    print('SANITY PASS:Survey Page back to Vessel Overview page')
    # Waiting for the page to load
    fPause(2)
    
    # Navigating to View All Links of Findings on Vessel Overview Page
    Paneltitle = browser.find_element_by_xpath('//main/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div/div[1]/a') 
    Paneltitle.click()
    print('SANITY PASS:Clicking on View All Links on Findings')
    # Waiting for the page to load
    fPause(2)
    
    #TAKING SS
    browser.switch_to.window(window_name=browser.window_handles[-1])
    ms = int(round(time.time() * 1000)) # creates unique timestamp : import time
    browser.save_screenshot("screenshots/screenshot_" + str(ms) + ".png") # saves image with unique name
    fPause(2)
    print('SANITY PASS:Taking SS')

    
    # Navigating Back to Vessel overview Page
    navToSublink(browser, pause, By, 'Vessel', 'Vessel Overview')
    print('SANITY PASS:Findings Page back to Vessel Overview page')
    # Waiting for the page to load
    fPause(2)
    
    # Navigating to View All Links of Certificates on Vessel Overview Page
    Paneltitle = browser.find_element_by_xpath('//main/div/div[2]/div[2]/div[2]/div[3]/div/div/div[1]/div/div[1]/a')
    Paneltitle.click()
    print('SANITY PASS:Clicking on View All Links on Certificates')
    # Waiting for the page to load
    fPause(2)
    
    #TAKING SS
    browser.switch_to.window(window_name=browser.window_handles[-1])
    ms = int(round(time.time() * 1000)) # creates unique timestamp : import time
    browser.save_screenshot("screenshots/screenshot_" + str(ms) + ".png") # saves image with unique name
    fPause(2)
    print('SANITY PASS:Taking SS')

    # Navigating Back to Vessel overview Page
    navToSublink(browser, pause, By, 'Vessel', 'Vessel Overview')
    print('SANITY PASS:Certificate Page back to Vessel Overview page')
    # Waiting for the page to load
    fPause(2)
    
    # Navigating to View All Links of Alerts on Vessel Overview Page
    Paneltitle = browser.find_element_by_xpath('//main/div/div[2]/div[2]/div[3]/div/div/div[1]/div[2]/a')
    Paneltitle.click()
    print('SANITY PASS:Clicking on View All Links on Alerts')
    # Waiting for the page to load
    fPause(2)
    
    #TAKING SS
    browser.switch_to.window(window_name=browser.window_handles[-1])
    ms = int(round(time.time() * 1000)) # creates unique timestamp : import time
    browser.save_screenshot("screenshots/screenshot_" + str(ms) + ".png") # saves image with unique name
    fPause(2)
    print('SANITY PASS:Taking SS')

    
    # Navigating Back to Vessel overview Page
    navToSublink(browser, pause, By, 'Vessel', 'Vessel Overview')
    print('SANITY PASS:Alerts Archive Page back to Vessel Overview page')
    # Waiting for the page to load
    fPause(2)
    
    #Trying to Logout
    Logout(browser, pause)
    print('SANITY PASS:Logout Successful')